# 🎯 Übung: GitHub Actions CI/CD Pipeline

**Tag 3 - Workflows & Build-Automatisierung**

---

## 📚 Was du in dieser Übung lernst

Nach dieser Übung kannst du:

- ✅ Einen vollständigen CI/CD Workflow erstellen
- ✅ Caching nutzen für schnellere Builds
- ✅ Tests automatisch ausführen
- ✅ Build-Artefakte hochladen
- ✅ Mit Matrix Builds mehrere Versionen testen
- ✅ Docker Images bauen (Bonus)

**Geschätzte Zeit:** 60-90 Minuten

---

## 🎓 Voraussetzungen

Du brauchst:
- [x] Einen GitHub Account
- [x] Ein Repository (eigenes oder geforktes Demo-Repo)
- [x] Grundkenntnisse aus Tag 1 & 2

**Hast du das Demo-Repository?**
- ✅ **JA** → Super! Nutze es für die Übung
- ❌ **NEIN** → Forke es hier: [Link zum Demo-Repo vom Dozenten]

---

## 📖 Die Aufgabe

Du bist Entwickler bei einem Startup und sollst eine **CI/CD Pipeline** für eure Web-Anwendung aufbauen.

### Die Anforderungen vom Team:

1. **Automatische Tests** bei jedem Code-Push
2. **Schnelle Builds** (mit Caching!)
3. **Build-Artefakte** für Deployment-Team
4. **Mehrere Node-Versionen** testen (Zukunftssicherheit)
5. **Docker Image** bauen (für Production)

**Deine Mission:** Baue einen Workflow der all das kann! 🚀

---

# Level 1: Basis-Workflow (30 Min)

## 🎯 Ziel
Erstelle einen funktionierenden CI/CD Workflow für Node.js

---

## Schritt 1: Repository vorbereiten (5 Min)

### A) Wenn du das Demo-Repo nutzt:

1. **Forke** das Demo-Repository (Button oben rechts)
2. **Clone** dein Fork:
   ```bash
   git clone https://github.com/DEIN-USERNAME/github-actions-demo.git
   cd github-actions-demo
   ```

### B) Wenn du ein eigenes Repo nutzt:

1. **Erstelle** ein neues Repository auf GitHub
2. **Clone** es lokal:
   ```bash
   git clone https://github.com/DEIN-USERNAME/DEIN-REPO.git
   cd DEIN-REPO
   ```

3. **Erstelle** eine einfache Node.js App:
   ```bash
   npm init -y
   echo "console.log('Hello CI/CD!');" > index.js
   echo "test('basic', () => expect(true).toBe(true));" > index.test.js
   ```

4. **Füge Scripts** zu `package.json` hinzu:
   ```json
   "scripts": {
     "test": "echo 'Running tests...' && exit 0",
     "build": "echo 'Building app...' && exit 0",
     "start": "node index.js"
   }
   ```

---

## Schritt 2: Workflow-Datei erstellen (10 Min)

### Erstelle die Datei:

```bash
mkdir -p .github/workflows
```

Erstelle: `.github/workflows/ci.yml`

### Aufgabe: Fülle das Gerüst aus!

```yaml
name: CI Pipeline

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      # TODO 1: Code auschecken
      # Tipp: Nutze actions/checkout@v4

      # TODO 2: Node.js installieren (Version 20)
      # Tipp: Nutze actions/setup-node@v4

      # TODO 3: Dependencies installieren
      # Tipp: Nutze npm ci (nicht npm install!)

      # TODO 4: Tests ausführen
      # Tipp: Nutze npm test

      # TODO 5: Build erstellen
      # Tipp: Nutze npm run build
```

---

### 💡 Hilfestellung: So füllt man die TODOs aus

<details>
<summary><b>Klick hier für Hilfe zu TODO 1: Code auschecken</b></summary>

```yaml
- name: Checkout Code
  uses: actions/checkout@v4
```

**Erklärung:**
- `uses:` nutzt eine vorgefertigte Action
- `actions/checkout@v4` holt deinen Code vom Repository
- Ohne diesen Step hättest du keine Dateien!

</details>

<details>
<summary><b>Klick hier für Hilfe zu TODO 2: Node.js installieren</b></summary>

```yaml
- name: Setup Node.js
  uses: actions/setup-node@v4
  with:
    node-version: '20'
```

**Erklärung:**
- `with:` gibt Parameter an die Action
- `node-version: '20'` installiert Node.js Version 20
- Du kannst auch andere Versionen nutzen: '18', '22', etc.

</details>

<details>
<summary><b>Klick hier für Hilfe zu TODO 3: Dependencies installieren</b></summary>

```yaml
- name: Install Dependencies
  run: npm ci
```

**Erklärung:**
- `run:` führt ein Shell-Kommando aus
- `npm ci` ist wie `npm install` aber für CI/CD optimiert
- Schneller und deterministisch (nutzt package-lock.json)

</details>

<details>
<summary><b>Klick hier für Hilfe zu TODO 4: Tests ausführen</b></summary>

```yaml
- name: Run Tests
  run: npm test
```

**Erklärung:**
- Führt deine Tests aus (definiert in package.json)
- Wenn Tests fehlschlagen → Workflow wird rot ❌
- Wenn Tests bestehen → Workflow geht weiter ✅

</details>

<details>
<summary><b>Klick hier für Hilfe zu TODO 5: Build erstellen</b></summary>

```yaml
- name: Build Application
  run: npm run build
```

**Erklärung:**
- Führt Build-Script aus (definiert in package.json)
- Erstellt optimierte Version deiner App
- Ergebnis landet meist in `dist/` oder `build/` Ordner

</details>

---

## Schritt 3: Workflow testen (10 Min)

### A) Committen & Pushen:

```bash
git add .
git commit -m "feat: add CI workflow"
git push origin main
```

### B) Workflow beobachten:

1. **Gehe zu GitHub** → Dein Repository
2. **Klicke** auf "Actions" Tab (oben)
3. **Siehst du** deinen Workflow?
4. **Klicke** drauf und schaue die Logs an

### ✅ Erfolgskriterium:
- Workflow ist **grün** ✅
- Alle Steps sind durchgelaufen
- Keine Fehler in den Logs

---

## Schritt 4: Fehlersuche (falls rot ❌)

### Häufige Fehler:

#### Fehler: "npm: command not found"
**Problem:** Node.js nicht installiert

**Lösung:** Check TODO 2 - Setup Node.js fehlt?

---

#### Fehler: "The package-lock.json file is not found"
**Problem:** package-lock.json fehlt

**Lösung:**
```bash
npm install
git add package-lock.json
git commit -m "chore: add package-lock.json"
git push
```

---

#### Fehler: "Missing script: build"
**Problem:** Build-Script in package.json fehlt

**Lösung:** Füge zu package.json hinzu:
```json
"scripts": {
  "build": "echo 'Build complete' && exit 0"
}
```

---

#### Fehler: "Actions is not enabled"
**Problem:** GitHub Actions nicht aktiviert

**Lösung:**
1. Settings → Actions → General
2. "Allow all actions" aktivieren
3. "Read and write permissions" aktivieren
4. Save

---

## ✅ Level 1 Checkpoint

**Hast du:**
- [x] Workflow-Datei erstellt
- [x] Alle TODOs ausgefüllt
- [x] Workflow läuft und ist grün ✅
- [x] Logs angeschaut

**JA?** → Weiter zu Level 2! 🎉

**NEIN?** → Frage deinen Dozenten oder Sitznachbarn

---

# Level 2: Performance-Optimierung (20 Min)

## 🎯 Ziel
Workflow mit Caching beschleunigen

---

## Warum Caching wichtig ist

**Problem ohne Cache:**
```
Run 1: npm ci → 2:15 Min (Dependencies laden)
Run 2: npm ci → 2:15 Min (Dependencies laden)
Run 3: npm ci → 2:15 Min (Dependencies laden)

Total: 6:45 Min verschwendet! 💸
```

**Mit Cache:**
```
Run 1: npm ci → 2:15 Min (Dependencies laden + Cache speichern)
Run 2: npm ci → 0:08 Sek (Cache restored!) ⚡
Run 3: npm ci → 0:08 Sek (Cache restored!) ⚡

Total: 2:31 Min - Ersparnis: 62%! 🚀
```

---

## Schritt 1: Caching aktivieren (10 Min)

### Aufgabe: Füge Caching hinzu!

**Öffne** `.github/workflows/ci.yml`

**Ändere** den "Setup Node.js" Step:

```yaml
- name: Setup Node.js
  uses: actions/setup-node@v4
  with:
    node-version: '20'
    cache: 'npm'  # ← Diese Zeile hinzufügen!
```

**Das war's!** 🎉 Eine Zeile = Automatisches Caching

---

## Schritt 2: Cache testen (10 Min)

### A) Erste Ausführung (Cache erstellen):

```bash
git add .
git commit -m "feat: add caching"
git push
```

**Schaue Logs an:**
- Step "Setup Node.js" → Siehst du "Cache not found"?
- Step "Post Setup Node.js" → Siehst du "Cache saved"?

**Das ist normal!** Erste Ausführung erstellt den Cache.

---

### B) Zweite Ausführung (Cache nutzen):

**Mache eine kleine Änderung:**

```bash
# Ändere was in README.md oder package.json Version
echo "# Test" >> README.md
git add .
git commit -m "chore: test cache"
git push
```

**Schaue Logs an:**
- Step "Setup Node.js" → Siehst du "Cache restored from key: ..."? ✅
- Step "Install Dependencies" → Viel schneller! ⚡

**Vergleiche die Zeiten:**
```
Erste Ausführung:  npm ci → ~2 Min
Zweite Ausführung: npm ci → ~8 Sek

Erfolg! 🎉
```

---

## 💡 Wie funktioniert das Caching?

```yaml
cache: 'npm'
```

**Was macht das?**

1. **Cache-Key erstellen:**
   - Basiert auf: Betriebssystem + package-lock.json Hash
   - Key ändert sich NUR wenn package-lock.json ändert
   - Beispiel: `Linux-npm-abc123def456`

2. **Beim ersten Run:**
   - Cache nicht gefunden
   - Dependencies werden installiert
   - Cache wird gespeichert

3. **Bei nachfolgenden Runs:**
   - Cache gefunden (gleicher Key)
   - Cache restored (3 Sekunden)
   - npm ci nutzt gecachte Dependencies (8 Sekunden)

**Wann wird neuer Cache erstellt?**
- Wenn du Dependencies änderst (package.json)
- package-lock.json ändert sich
- Neuer Cache-Key
- Dependencies werden neu geladen

---

## ✅ Level 2 Checkpoint

**Hast du:**
- [x] `cache: 'npm'` hinzugefügt
- [x] Workflow 2x laufen lassen
- [x] Cache-Logs gesehen ("restored from key")
- [x] Geschwindigkeitsunterschied bemerkt

**JA?** → Weiter zu Level 3! 🚀

---

# Level 3: Artifacts & Matrix (25 Min)

## 🎯 Ziel
Build-Ergebnisse speichern und mehrere Versionen testen

---

## Teil A: Artifacts hochladen (10 Min)

### Was sind Artifacts?

**Artifacts** = Build-Ergebnisse die du speichern und herunterladen kannst

**Beispiele:**
- JAR-Dateien (Java)
- Compiled Code
- Test Reports
- Coverage Reports
- Logs

---

### Aufgabe: Build-Artifact hochladen

**Füge am Ende deines Workflows hinzu:**

```yaml
      # Nach dem Build Step...

      - name: Upload Build Artifact
        uses: actions/upload-artifact@v4
        with:
          name: build-output
          path: dist/
          retention-days: 7
```

**Erklärung:**
- `name:` - Name des Artifacts (für Download)
- `path:` - Was hochladen? (Ordner oder Datei)
- `retention-days:` - Wie lange aufbewahren? (max 90 Tage)

---

### Artifact testen:

```bash
git add .
git commit -m "feat: add artifact upload"
git push
```

**Nach Workflow:**
1. **Gehe zu** Workflow-Run
2. **Scrolle runter** → Siehst du "Artifacts" Bereich?
3. **Klicke** "build-output" zum Downloaden

**Falls nichts da ist:**
- Check: Gibt es einen `dist/` Ordner nach dem Build?
- Wenn nicht, ändere `path:` zu existierendem Ordner
- Oder erstelle dummy-Datei:
  ```yaml
  - run: mkdir -p dist && echo "test" > dist/test.txt
  ```

---

## Teil B: Matrix Strategy (15 Min)

### Was ist eine Matrix?

**Matrix** = Workflow auf mehreren Varianten parallel laufen lassen

**Use Cases:**
- Mehrere Node-Versionen (18, 20, 22)
- Mehrere Betriebssysteme (Ubuntu, Windows, macOS)
- Mehrere Browser (Chrome, Firefox, Safari)

---

### Aufgabe: Teste auf 3 Node-Versionen

**Erstelle** neue Datei: `.github/workflows/matrix-test.yml`

```yaml
name: Matrix Build

on:
  push:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest

    strategy:
      matrix:
        node-version: [18, 20, 22]

    steps:
      - uses: actions/checkout@v4

      - name: Setup Node ${{ matrix.node-version }}
        uses: actions/setup-node@v4
        with:
          node-version: ${{ matrix.node-version }}
          cache: 'npm'

      - run: npm ci

      - run: npm test

      - name: Show Node Version
        run: node --version
```

**Was passiert?**
- GitHub erstellt **3 Jobs** automatisch
- Ein Job für Node 18
- Ein Job für Node 20
- Ein Job für Node 22
- Alle laufen **parallel**!

---

### Matrix testen:

```bash
git add .
git commit -m "feat: add matrix build"
git push
```

**Schaue Actions an:**
- Siehst du **3 Jobs** laufen?
- Jeder mit eigener Node-Version
- Alle parallel! ⚡

**Check Logs:**
- Öffne einen Job
- Schaue "Show Node Version" Step
- Siehst du die richtige Version?

---

### 💡 Matrix Advanced (Optional)

**Du kannst auch mehrere Dimensionen kombinieren:**

```yaml
strategy:
  matrix:
    node-version: [18, 20, 22]
    os: [ubuntu-latest, windows-latest, macos-latest]
```

**Ergebnis:** 9 Jobs! (3 Versionen × 3 OS)

**Oder mit exclude:**

```yaml
strategy:
  matrix:
    node-version: [18, 20, 22]
    os: [ubuntu-latest, windows-latest]
    exclude:
      - node-version: 18
        os: windows-latest
```

---

## ✅ Level 3 Checkpoint

**Hast du:**
- [x] Artifact hochgeladen
- [x] Artifact heruntergeladen
- [x] Matrix-Workflow erstellt
- [x] 3 parallele Jobs gesehen

**JA?** → Optional: Level 4 (Docker)! 🐳

---

# Level 4: Docker Build (Bonus - 20 Min)

## 🎯 Ziel
Docker Image bauen und zu Registry pushen

**Hinweis:** Dieser Level ist **optional** und etwas anspruchsvoller!

---

## Schritt 1: Dockerfile erstellen (5 Min)

**Erstelle** im Root: `Dockerfile`

```dockerfile
FROM node:20-alpine

WORKDIR /app

COPY package*.json ./
RUN npm ci --only=production

COPY . .

EXPOSE 3000

CMD ["npm", "start"]
```

**Erklärung:**
- `FROM node:20-alpine` - Kleines Base-Image (40 MB statt 900 MB!)
- `WORKDIR /app` - Arbeitsverzeichnis im Container
- `COPY package*.json` - Erst Dependencies (für Layer-Caching)
- `RUN npm ci` - Dependencies installieren
- `COPY . .` - Rest vom Code kopieren
- `EXPOSE 3000` - Port freigeben
- `CMD` - Start-Command

---

## Schritt 2: Docker Workflow erstellen (10 Min)

**Erstelle:** `.github/workflows/docker.yml`

```yaml
name: Docker Build

on:
  push:
    branches: [ main ]

jobs:
  docker:
    runs-on: ubuntu-latest

    permissions:
      contents: read
      packages: write

    steps:
      - uses: actions/checkout@v4

      - name: Build Docker Image
        run: docker build -t myapp:latest .

      - name: Test Docker Image
        run: |
          docker run -d -p 3000:3000 --name test myapp:latest
          sleep 5
          docker logs test
          docker stop test

      - name: Login to GitHub Container Registry
        uses: docker/login-action@v3
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}

      - name: Push to GHCR
        run: |
          IMAGE_NAME=ghcr.io/${{ github.repository }}:latest
          docker tag myapp:latest $IMAGE_NAME
          docker push $IMAGE_NAME
```

**Erklärung:**
- `permissions:` - Brauchen wir für GHCR Push
- Build Image lokal
- Test ob Image funktioniert
- Login zu GitHub Container Registry
- Push Image zu GHCR

---

## Schritt 3: Docker testen (5 Min)

```bash
git add .
git commit -m "feat: add docker build"
git push
```

**Check:**
1. Workflow läuft?
2. Docker Build erfolgreich?
3. Test erfolgreich?
4. Push erfolgreich?

**Image anschauen:**
1. Gehe zu deinem GitHub Repo
2. Rechts: "Packages" → Siehst du dein Image?

---

### 🐛 Häufige Docker-Fehler:

#### "Permission denied"
**Lösung:**
- Settings → Actions → General
- Workflow permissions: "Read and write" ✅

#### "docker: command not found"
**Das sollte nicht passieren** - Docker ist vorinstalliert in GitHub Actions

#### "Build failed"
**Check:**
- Dockerfile Syntax korrekt?
- Alle Dateien vorhanden?
- package.json existiert?

---

## ✅ Level 4 Checkpoint

**Hast du:**
- [x] Dockerfile erstellt
- [x] Docker Workflow erstellt
- [x] Image gebaut
- [x] Image getestet
- [x] Image zu GHCR gepusht

**JA?** → Du bist ein GitHub Actions Pro! 🏆

---

# 🎉 Herzlichen Glückwunsch!

## Was du geschafft hast:

### Level 1: ✅ Basis-Workflow
- Node.js CI Pipeline erstellt
- Tests automatisiert
- Build automatisiert

### Level 2: ✅ Performance
- Caching implementiert
- 60%+ schneller!

### Level 3: ✅ Advanced
- Artifacts hochgeladen
- Matrix Builds mit 3 Versionen

### Level 4: ✅ Docker (Optional)
- Docker Image gebaut
- Zu Registry gepusht

---

## 📊 Selbst-Check

**Kannst du jetzt:**
- [ ] Einen Workflow von Grund auf erstellen?
- [ ] Erklären was `uses:` und `run:` macht?
- [ ] Caching aktivieren?
- [ ] Artifacts hochladen?
- [ ] Matrix Strategy nutzen?
- [ ] Docker Images bauen? (Bonus)

**Alle checked?** → Du bist bereit für eigene Projekte! 🚀

---

## 🎓 Nächste Schritte

### Für zuhause:

1. **Eigenes Projekt:**
   - Nimm ein eigenes Projekt
   - Baue einen CI/CD Workflow dafür
   - Teile es mit deinem Team

2. **Erweitere den Workflow:**
   - Füge Linting hinzu (ESLint)
   - Code Coverage Reports
   - Deployment (z.B. zu Heroku, Vercel)
   - Slack-Benachrichtigungen

3. **Lerne mehr:**
   - [GitHub Actions Docs](https://docs.github.com/actions)
   - [Awesome Actions](https://github.com/sdras/awesome-actions)
   - [Marketplace](https://github.com/marketplace?type=actions)

---

## 📝 Reflexion

**Was war einfach?**
- _____________________________________

**Was war schwierig?**
- _____________________________________

**Was möchtest du noch lernen?**
- _____________________________________

---

## 🆘 Hilfe & Troubleshooting

### Workflow läuft nicht?

**Check:**
1. Actions aktiviert? (Settings → Actions)
2. .github/workflows/ Ordner korrekt?
3. YAML-Syntax korrekt? (Einrückung!)
4. Main Branch?

### Cache funktioniert nicht?

**Check:**
1. `cache: 'npm'` hinzugefügt?
2. package-lock.json existiert?
3. Erste Ausführung? (Cache wird erstellt)

### Tests schlagen fehl?

**Check:**
1. Tests lokal ausführen: `npm test`
2. Fehler fixen
3. Neu committen & pushen

### Docker Build schlägt fehl?

**Check:**
1. Dockerfile Syntax
2. Permissions gesetzt?
3. Alle Dateien vorhanden?

---

## 📞 Support

**Fragen? Probleme?**

1. **Frage deinen Dozenten**
2. **Frage deinen Sitznachbarn**
3. **GitHub Discussions** in deinem Repo
4. **Stack Overflow** - Tag: `github-actions`

---

## 🏆 Bonus-Challenges

**Für die Schnellen:**

### Challenge 1: Conditional Steps
Führe Steps nur bei bestimmten Bedingungen aus:

```yaml
- name: Deploy to Production
  if: github.ref == 'refs/heads/main'
  run: echo "Deploying..."
```

### Challenge 2: Secrets nutzen
Füge ein Secret hinzu und nutze es:

```yaml
- name: Use Secret
  run: echo "API Key: ${{ secrets.MY_SECRET }}"
```

Settings → Secrets → New secret

### Challenge 3: Reusable Workflow
Erstelle einen wiederverwendbaren Workflow:

```yaml
# .github/workflows/reusable.yml
on:
  workflow_call:
    inputs:
      node-version:
        required: true
        type: string
```

### Challenge 4: Multiple Jobs mit Dependencies
Erstelle Jobs die nacheinander laufen:

```yaml
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - run: echo "Building..."

  test:
    needs: build  # Wartet auf build!
    runs-on: ubuntu-latest
    steps:
      - run: echo "Testing..."

  deploy:
    needs: test  # Wartet auf test!
    runs-on: ubuntu-latest
    steps:
      - run: echo "Deploying..."
```

---

**Viel Erfolg! Du schaffst das! 💪**

**Happy CI/CD! 🚀**
