# 🚀 QUICK START - In 5 Minuten zum fertigen Demo-Repo!

## Schritt 1: GitHub Repository erstellen (1 Min)

1. Gehe zu [github.com](https://github.com)
2. Klicke "New Repository"
3. Name: `github-actions-demo`
4. Public oder Private
5. **NICHT** initialisiere mit README
6. Create Repository

## Schritt 2: Diesen Ordner hochladen (2 Min)

```bash
# Terminal öffnen
cd "/Users/andyschwarz/Documents/CloudHelden/Praxisaufgaben/CICD-GitHub-Action/Tag-3-Workflows-und-Automatisierung/Demo-Repository-Vorlage"

# Git initialisieren
git init
git add .
git commit -m "feat: Initial GitHub Actions demo setup"

# Mit deinem GitHub verbinden (ERSETZE DEIN-USERNAME!)
git remote add origin https://github.com/DEIN-USERNAME/github-actions-demo.git
git branch -M main
git push -u origin main
```

## Schritt 3: Actions aktivieren (1 Min)

1. Gehe zu deinem Repository auf GitHub
2. Klicke **Settings** (oben rechts)
3. **Actions** → **General** (links)
4. "Allow all actions and reusable workflows" ✅
5. Workflow permissions: "Read and write permissions" ✅
6. **Save**

## Schritt 4: Workflows starten (1 Min)

1. Gehe zu **Actions** Tab
2. Du siehst deine Workflows!
3. Sie starten automatisch beim nächsten Push
4. ODER: Workflow auswählen → "Run workflow"

---

## ✅ Fertig!

Dein Repository ist jetzt bereit für:
- ✅ Node.js CI/CD
- ✅ Java Maven CI/CD
- ✅ Docker Build & Push
- ✅ Caching Demos

---

## 🧪 Lokales Testen (Optional)

### Frontend testen:
```bash
cd frontend
npm install
npm test
npm start
# Browser: http://localhost:3000
```

### Backend testen:
```bash
cd backend
mvn test
mvn package
java -jar target/backend-demo-1.0.0.jar
```

### Docker testen:
```bash
docker build -t demo .
docker run -p 3000:3000 demo
# Browser: http://localhost:3000
```

---

## 🎓 Für den Unterricht

### Vor dem Kurs:
1. Repository einmal komplett durchlaufen lassen
2. Check: Alle Workflows grün?
3. Check: Artifacts vorhanden?
4. Screenshots machen (als Backup)

### Während dem Kurs:
1. Zeige Actions Tab
2. Zeige Workflow-Logs
3. Zeige Artifacts Download
4. Ändere Code → Push → Zeige neuen Run

### Häufige Demo-Szenarien:

**Demo 1: Cache-Effekt zeigen**
```bash
# Ändere frontend/index.js (z.B. Versionsnummer)
# Push
# Zeige: Cache restored → npm ci schnell!
```

**Demo 2: Matrix Strategy**
```bash
# Zeige java-build Workflow
# 3 Jobs parallel (Java 11, 17, 21)
```

**Demo 3: Docker Build**
```bash
# Pushe zu main
# Zeige Docker-Workflow
# Check: GitHub Packages → Image ist da!
```

---

## 🐛 Problem? Hier sind Lösungen:

### Problem: "npm ci failed"
```bash
cd frontend
npm install
git add package-lock.json
git commit -m "fix: add lockfile"
git push
```

### Problem: "Maven build failed"
```bash
cd backend
mvn clean install
# Wenn Fehler: Tests fixen
git add .
git commit -m "fix: tests"
git push
```

### Problem: "Workflows run nicht"
- Check: Actions aktiviert?
- Check: .github/workflows/ vorhanden?
- Check: Branch = main?

### Problem: "Docker Push failed"
- Settings → Actions → Permissions
- "Read and write permissions" ✅

---

## 💡 Pro-Tipps

1. **Zwei Repos:**
   - Eins für Demos (funktioniert perfekt)
   - Eins für "Fehler zeigen" (mit Absicht kaputt)

2. **Branches nutzen:**
   - `main` = Alles funktioniert
   - `demo-error` = Zum Debuggen zeigen
   - `demo-cache` = Cache deaktiviert zum Vergleich

3. **Screenshots:**
   - Mache Screenshots von erfolgreichen Runs
   - Falls GitHub langsam ist
   - Für schnelles Durchklicken

4. **Trockenübung:**
   - Lauf alles 1x durch VOR dem Kurs
   - Check: Alle Workflows grün?
   - Teste auch Fehler-Szenarien

---

**Viel Erfolg! Bei Fragen: Einfach melden! 🚀**
