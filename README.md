# GitHub Actions Demo Repository - Tag 3

Dieses Repository enthält Demo-Code für den GitHub Actions Kurs (Tag 3).

## 📁 Struktur

```
github-actions-demo/
├── .github/
│   └── workflows/          # GitHub Actions Workflows
├── frontend/               # Node.js Beispiel-Projekt
│   ├── package.json
│   ├── index.js
│   └── test.js
├── backend/                # Java Maven Beispiel-Projekt
│   ├── pom.xml
│   └── src/
│       ├── main/java/
│       └── test/java/
├── Dockerfile              # Multi-Stage Docker Build
├── .dockerignore
├── .gitignore
└── README.md
```

## 🚀 Lokales Testen

### Frontend (Node.js)

```bash
cd frontend
npm install
npm test
npm start
# Öffne: http://localhost:3000
```

**Endpoints:**
- `GET /` - Hello Message
- `GET /health` - Health Check
- `GET /api/greet/:name` - Greet API

### Backend (Java)

```bash
cd backend
mvn clean test          # Tests ausführen
mvn package            # JAR erstellen
java -jar target/backend-demo-1.0.0.jar  # Ausführen
```

### Docker

```bash
# Image bauen
docker build -t demo-app:latest .

# Container starten
docker run -d -p 3000:3000 --name demo demo-app:latest

# Testen
curl http://localhost:3000
curl http://localhost:3000/health

# Logs anschauen
docker logs demo

# Cleanup
docker stop demo && docker rm demo
```

## 🔄 GitHub Actions Workflows

### 1. Node.js CI (`nodejs-build.yml`)
- Checkout Code
- Setup Node.js 20
- Install Dependencies (mit Cache)
- Run Tests
- Build Application
- Upload Artifacts

**Trigger:** Push & Pull Request

### 2. Java CI (`java-build.yml`)
- Checkout Code
- Setup Java 17
- Maven Build & Test (mit Cache)
- Upload JAR
- Matrix: Java 11, 17, 21

**Trigger:** Push & Pull Request

### 3. Docker Build (`docker-build.yml`)
- Build Docker Image
- Test Image
- Push zu GitHub Container Registry (GHCR)
- Tags: latest + commit SHA

**Trigger:** Push zu main

### 4. Caching Demo (`nodejs-cache.yml`)
- Zeigt Performance-Unterschied
- Mit/Ohne Cache
- Automatisches npm Caching

**Trigger:** Manual (workflow_dispatch)

## ⚙️ Setup für GitHub Actions

### 1. Repository auf GitHub erstellen

```bash
git init
git add .
git commit -m "feat: Initial commit"
git branch -M main
git remote add origin https://github.com/DEIN-USERNAME/REPO-NAME.git
git push -u origin main
```

### 2. Actions aktivieren

- Gehe zu **Settings** → **Actions** → **General**
- Aktiviere: "Allow all actions and reusable workflows"
- Workflow permissions: "Read and write permissions" ✅

### 3. Secrets einrichten (für Docker Push)

**Für Docker Hub:**
- Settings → Secrets and variables → Actions
- `DOCKERHUB_USERNAME` = Dein Username
- `DOCKERHUB_TOKEN` = Access Token

**Für GitHub Container Registry (GHCR):**
- Keine Secrets nötig!
- Nutzt automatisch `GITHUB_TOKEN`

### 4. Workflows testen

- Pushe Code → Actions automatisch gestartet
- Oder: Actions Tab → Workflow auswählen → "Run workflow"

## 📊 Monitoring

### Workflow Status anzeigen

Füge Badge in README ein:

```markdown
![CI](https://github.com/USERNAME/REPO/workflows/Node.js%20CI/badge.svg)
```

### Actions Tab

- Zeigt alle Workflow-Runs
- Live-Logs
- Artifacts Download
- Job-Übersicht

## 🐛 Troubleshooting

### npm ci schlägt fehl

```bash
# package-lock.json fehlt
npm install
git add package-lock.json
git commit -m "chore: add lockfile"
git push
```

### Maven Tests schlagen fehl

```bash
# Lokal testen
cd backend
mvn clean test
# Fehler fixen, dann pushen
```

### Docker Build zu langsam

- ✅ Bereits optimiert: Alpine Images
- ✅ Multi-Stage Build
- ✅ Layer Caching
- ✅ .dockerignore

### Workflows laufen nicht

1. Check: Actions aktiviert?
2. Check: YAML-Syntax korrekt? (`yamllint`)
3. Check: .github/workflows/ Ordner?
4. Check: Branch korrekt? (main/master)

## 📚 Ressourcen

- [GitHub Actions Docs](https://docs.github.com/actions)
- [Docker Best Practices](https://docs.docker.com/develop/dev-best-practices/)
- [Maven Guide](https://maven.apache.org/guides/)

## 🎓 Lernziele

Nach diesem Projekt kannst du:

- ✅ Workflows für Node.js und Java erstellen
- ✅ Caching nutzen (60%+ schneller!)
- ✅ Docker Images bauen und pushen
- ✅ Matrix Builds mit mehreren Versionen
- ✅ Artifacts zwischen Jobs übergeben
- ✅ GitHub Container Registry nutzen

## 🤝 Contributing

Dies ist ein Lern-Repository. Feel free to fork & experimentieren!

## 📝 License

MIT

---

**Happy CI/CD Learning! 🚀**
