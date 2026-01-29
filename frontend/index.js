const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

// Root endpoint
app.get('/', (req, res) => {
  res.json({
    message: 'Hello from GitHub Actions Demo! 🚀',
    service: 'Frontend',
    timestamp: new Date().toISOString(),
    version: '1.0.0'
  });
});

// Health check endpoint
app.get('/health', (req, res) => {
  res.status(200).json({
    status: 'healthy',
    uptime: process.uptime()
  });
});

// API endpoint
app.get('/api/greet/:name', (req, res) => {
  const { name } = req.params;
  res.json({
    greeting: `Hello, ${name}! Welcome to CI/CD!`
  });
});

// Start server
if (require.main === module) {
  app.listen(PORT, () => {
    console.log(`✓ Frontend server running on port ${PORT}`);
    console.log(`✓ Health check: http://localhost:${PORT}/health`);
  });
}

module.exports = app;
