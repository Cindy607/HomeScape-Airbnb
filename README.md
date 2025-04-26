# Airbnb Management System (Mini Project)

Welcome to the **Airbnb Management System**, a full-stack project built using **Java Spring Boot**, **HTML/CSS/JavaScript**, and **H2 Database**.  
This system simulates the basic functionality of an Airbnb platform where Hosts can manage apartments, and Clients can search and book them.

---

## ✨ Features

### Host Functionalities:
- Register as a Host
- Login as a Host
- Add new Apartments
- View owned Apartments
- Remove Apartments
- Log Out

### Client Functionalities:
- Register as a Client
- Login as a Client
- Search Apartments by Location
- Make Reservations
- View My Reservations
- Cancel Reservations
- Log Out

---

## 🛠 Technologies Used

- **Backend**: Java Spring Boot (Spring Web, Spring Data JPA)
- **Frontend**: HTML, CSS, JavaScript
- **Database**: H2 (in-memory database)
- **Build Tool**: Maven
- **Version Control**: Git, GitHub

---

## 📂 Project Structure


---

## 🔗 Backend API Endpoints

| Method | URL | Purpose |
|:-------|:----|:--------|
| POST | `/clients/register` | Register new client |
| POST | `/hosts/register` | Register new host |
| POST | `/clients/login` | Client login |
| POST | `/hosts/login` | Host login |
| POST | `/apartments/add` | Add new apartment |
| GET | `/apartments/host/{hostId}` | View apartments by host |
| DELETE | `/apartments/{apartmentId}` | Remove apartment |
| GET | `/apartments/search?location=...` | Search apartments |
| POST | `/reservations/make` | Make reservation |
| GET | `/reservations/client/{clientId}` | View client reservations |
| DELETE | `/reservations/{reservationId}` | Cancel reservation |

---

## 🚀 How to Run Locally

### Backend:

1. Open the `backend` folder in IntelliJ IDEA.
2. Make sure JDK 17+ is installed.
3. Run `BackendApplication.java`.
4. Server runs at: `http://localhost:8080`

### Frontend:

1. Open the `frontend` folder in VS Code.
2. Open `index.html` in the browser.
3. Start using the system!

---

## 📈 Future Improvements

- Switch database from H2 to MySQL for persistence.
- Deploy backend (Render, Railway, Heroku).
- Deploy frontend (Netlify, Vercel).
- Add authentication (JWT Token).
- Improve UI/UX design.

---

## 🧑‍💻 Project Authors

- **[Your Name Here]**
- Technologies: Java, Spring Boot, HTML, CSS, JavaScript
- GitHub: [Insert your GitHub Profile Link]

---

# 📢 Final Words

✅ This project demonstrates a complete **Backend + Frontend** connection using modern web development techniques.  
✅ It replicates real-world Airbnb functionalities.  
✅ It is structured cleanly, scalable, and ready for further improvements.

---
