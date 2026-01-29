# Multi-Stage Dockerfile für Node.js Frontend
# Optimiert für kleine Image-Größe und schnelle Builds

# ============================================
# Stage 1: Builder
# ============================================
FROM node:20-alpine AS builder

WORKDIR /app

# Dependencies installieren (Layer Caching!)
COPY frontend/package*.json ./
RUN npm ci --only=production

# Code kopieren
COPY frontend/ .

# Build (falls vorhanden)
RUN npm run build 2>/dev/null || echo "No build step defined"

# ============================================
# Stage 2: Production
# ============================================
FROM node:20-alpine

# Security: Nicht als root laufen
RUN addgroup -g 1001 -S nodejs && \
    adduser -S nodejs -u 1001

WORKDIR /app

# Nur Notwendiges kopieren
COPY --from=builder --chown=nodejs:nodejs /app/node_modules ./node_modules
COPY --from=builder --chown=nodejs:nodejs /app/package*.json ./
COPY --chown=nodejs:nodejs frontend/*.js ./

# Metadata
LABEL maintainer="CloudHelden"
LABEL description="GitHub Actions Demo - Frontend"
LABEL version="1.0.0"

# User wechseln
USER nodejs

# Port
EXPOSE 3000

# Health Check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD node -e "require('http').get('http://localhost:3000/health', (r) => {process.exit(r.statusCode === 200 ? 0 : 1)})" || exit 1

# Start
CMD ["node", "index.js"]
