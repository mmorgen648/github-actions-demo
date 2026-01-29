# 🚀 GitHub Actions Demo - Tag 3

Willkommen zum **GitHub Actions Training (Tag 3)**!
Dieses Repository enthält Beispiel-Code und Übungsaufgaben zum Lernen von CI/CD.

---

## 📖 👉 **[ZU DEN ÜBUNGSAUFGABEN (START HIER!)](ÜBUNG-Teilnehmer.md)** 👈

---

## 📚 Was ist das?

Dieses Repository ist Teil des **CloudHelden GitHub Actions Trainings**.
Es zeigt praktische Beispiele für:

- ✅ **Node.js CI/CD** (npm, testing, build)
- ✅ **Java CI/CD** (Maven, testing, artifacts)
- ✅ **Docker Build** (Multi-Stage, GHCR Push)
- ✅ **Caching** (schnellere Builds)
- ✅ **Artifacts** (Build-Ergebnisse speichern)

---

## 🎯 Schnellstart für Teilnehmer

### ⚡ Option 1: Forken (EINFACHSTE Methode - 2 Minuten)

1. **Klicke oben rechts auf "Fork"**
2. Wähle deinen Account
3. Warte 10 Sekunden
4. **Fertig!** Workflows laufen automatisch
5. **Öffne:** [ÜBUNG-Teilnehmer.md](ÜBUNG-Teilnehmer.md) und starte mit Level 1

### Option 2: Als Template nutzen

1. Klicke auf **"Use this template"** (grüner Button, falls verfügbar)
2. Erstelle dein eigenes Repository
3. Clone es lokal: `git clone https://github.com/DEIN-USERNAME/REPO-NAME.git`

---

## 🏆 Übungsaufgaben

Die Übung hat **4 Level**:

| Level | Thema | Dauer | Schwierigkeit |
|-------|-------|-------|---------------|
| **Level 1** | Basis-Workflow erstellen | 30 Min | 🟢 Pflicht |
| **Level 2** | Caching hinzufügen | 20 Min | 🟢 Pflicht |
| **Level 3** | Artifacts & Matrix | 25 Min | 🟡 Empfohlen |
| **Level 4** | Docker Build | 20 Min | 🔵 Bonus |

**👉 [Zu den Übungsaufgaben](ÜBUNG-Teilnehmer.md)**

---

## 🔧 Voraussetzungen

- ✅ GitHub Account (kostenlos)
- ✅ Git installiert (oder GitHub Desktop)
- ✅ Code-Editor (VS Code empfohlen)
- ⚠️ Node.js/Java (nur für lokales Testen, optional)

**Tipp:** Du musst nichts lokal installieren! Alles läuft in GitHub Actions.

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

## 🆘 Hilfe & Troubleshooting

### ❌ Workflows laufen nicht?

**Check 1:** Actions aktiviert?
- Gehe zu: **Settings** → **Actions** → **General**
- Wähle: "Allow all actions"
- Permissions: "Read and write"

**Check 2:** Branch heißt `main`?
- Workflows triggern auf `main` Branch
- Falls du `master` hast → Branch umbenennen

**Check 3:** Workflows manuell starten
- Gehe zu **Actions** Tab
- Wähle einen Workflow (links)
- Klicke **"Run workflow"** (rechts)

### ❌ Workflows schlagen fehl?

1. Öffne **Actions** Tab
2. Klicke auf den roten Workflow-Run
3. Klicke auf den roten Step
4. Lies die Fehlermeldung
5. Frage deinen Dozenten oder schaue in die Logs

### 💡 Weitere Hilfe

- Frage deinen Dozenten
- Schaue in die Workflow-Logs (Actions Tab)
- Erstelle ein Issue in diesem Repository

## 📚 Ressourcen

- [GitHub Actions Docs](https://docs.github.com/actions)
- [Docker Best Practices](https://docs.docker.com/develop/dev-best-practices/)
- [Maven Guide](https://maven.apache.org/guides/)

## 🎓 Was du lernen wirst

Nach diesem Training kannst du:

- ✅ Eigene GitHub Actions Workflows erstellen
- ✅ Node.js und Java Projekte automatisch bauen
- ✅ Tests automatisch ausführen
- ✅ Caching nutzen (bis zu 70% schneller!)
- ✅ Docker Images bauen und pushen
- ✅ Artifacts hochladen und nutzen
- ✅ Matrix Builds (mehrere Versionen parallel)

---

## 🏆 Erfolgs-Checks

Du bist fertig, wenn:

- [ ] Du hast das Repository geforkt
- [ ] Alle Workflows laufen (grüne Häkchen ✓)
- [ ] Du hast Level 1 & 2 abgeschlossen
- [ ] Du verstehst wie Caching funktioniert
- [ ] Du kannst eigene Workflows schreiben

---

## 📝 Lizenz

MIT License - Frei verwendbar für Lernzwecke

---

## 👨‍🏫 Erstellt von

**CloudHelden** - GitHub Actions Training
Tag 3: Workflows & Build-Automatisierung

---

**Viel Erfolg! 🎉**

**👉 [Jetzt mit den Übungen starten!](ÜBUNG-Teilnehmer.md)** 👈
