# Proiect-JAVA

### [Video Link](https://drive.google.com/file/d/1yZVe1SQY9r1KBVslqY74fUx5qQyliGHq/view?usp=drive_link)

Desigur! Iată un scurt rezumat al proiectului:

### **Scopul Proiectului**
Acest proiect Java este o aplicație desktop pentru gestionarea utilizatorilor și angajaților într-o bază de date MySQL. Aplicația permite înregistrarea, autentificarea și manipularea datelor angajaților, cum ar fi adăugarea, căutarea, actualizarea și ștergerea acestora.

### **Structura Proiectului**

1. **LoginForm (Autentificare)**:
   - O fereastră de autentificare în care utilizatorii își introduc adresa de email și parola.
   - Autentificarea se face printr-o interogare SQL în baza de date MySQL, comparând credențialele introduse cu cele din tabelul `users`.

2. **RegistrationForm (Înregistrare utilizator)**:
   - Permite utilizatorilor să se înregistreze prin completarea unui formular.
   - Informațiile sunt stocate într-un tabel `users` din baza de date.

3. **DashboardForm (Administrarea angajaților)**:
   - Fereastra principală a aplicației după autentificare.
   - Afișează o listă de angajați din tabelul `employee` în baza de date.
   - Permite adăugarea, căutarea și ștergerea informațiilor despre angajați, precum numele, salariul și numărul de telefon.
   - Datele sunt afișate într-un tabel (JTable), iar acțiunile sunt legate de interogări SQL pentru manipularea datelor în baza de date.

### **Tehnologii Folosite**
- **Java Swing**: pentru crearea interfeței grafice (formulare de login, dashboard).
- **MySQL**: baza de date utilizată pentru stocarea și manipularea datelor utilizatorilor și angajaților.
- **JDBC (Java Database Connectivity)**: pentru interacțiunea între aplicația Java și baza de date MySQL.
- **ORM simplificat (DbUtils)**: pentru popularea tabelului din interfață cu date din baza de date.

### **Fluxul Principal**
1. **Autentificare**: Utilizatorul introduce emailul și parola în `LoginForm`.
2. **Administrare Angajați**: În `DashboardForm`, utilizatorul poate adăuga, căuta și șterge angajați din baza de date.
3. **Interogări SQL**: Aplicația folosește interogări SQL pentru toate operațiunile legate de baza de date (autentificare, gestionarea angajaților).

### **Exemplu de Funcționalitate**
- Un utilizator se autentifică cu succes folosind credențialele stocate în baza de date.
- Se poate adăuga un nou angajat, cu numele, salariul și numărul de telefon. Informațiile sunt salvate în baza de date și sunt afișate într-un tabel din interfața grafică.

Proiectul este o aplicație simplă de gestionare a utilizatorilor și angajaților cu o interfață grafică de utilizator (GUI), utilizând Java și MySQL pentru a crea o soluție completă de gestionare a datelor.
