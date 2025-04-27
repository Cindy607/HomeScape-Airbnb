// 🚀 These navigation functions must be OUTSIDE DOMContentLoaded
function registerHost() {
    window.location.href = 'register-host.html';
}

function registerClient() {
    window.location.href = 'register-client.html';
}

function loginHost() {
    window.location.href = 'login-host.html';
}

function loginClient() {
    window.location.href = 'login-client.html';
}

function exitApp() {
    alert("Thank you for using the system. Goodbye!");
}

// 🚀 This is for forms and dynamic actions
document.addEventListener("DOMContentLoaded", function () {
    // Host Registration
    const hostRegisterForm = document.getElementById('hostRegisterForm');
    if (hostRegisterForm) {
        hostRegisterForm.addEventListener('submit', async function (e) {
            e.preventDefault();
            const name = document.getElementById('hostName').value.trim();
            const email = document.getElementById('hostEmail').value.trim();
            const password = document.getElementById('hostPassword').value.trim();
            const confirmPassword = document.getElementById('hostConfirmPassword').value.trim();

            if (!validateName(name) || !validateEmail(email) || !validatePassword(password) || password !== confirmPassword) {
                alert("Please check your inputs!");
                return;
            }

            const host = { name, email, password };

            const response = await fetch('http://localhost:8080/hosts/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(host)
            });

            if (response.ok) {
                alert("Host registered successfully!");
                window.location.href = 'register-success.html';
            } else {
                alert("Error registering host.");
            }
        });
    }

    // Client Registration
    const clientRegisterForm = document.getElementById('clientRegisterForm');
    if (clientRegisterForm) {
        clientRegisterForm.addEventListener('submit', async function (e) {
            e.preventDefault();
            const name = document.getElementById('clientName').value.trim();
            const email = document.getElementById('clientEmail').value.trim();
            const password = document.getElementById('clientPassword').value.trim();
            const confirmPassword = document.getElementById('clientConfirmPassword').value.trim();

            if (!validateName(name) || !validateEmail(email) || !validatePassword(password) || password !== confirmPassword) {
                alert("Please check your inputs!");
                return;
            }

            const client = { name, email, password };

            const response = await fetch('http://localhost:8080/clients/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(client)
            });

            if (response.ok) {
                alert("Client registered successfully!");
                window.location.href = 'register-success.html';
            } else {
                alert("Error registering client.");
            }
        });
    }

    // Host Login
    const hostLoginForm = document.getElementById('hostLoginForm');
    if (hostLoginForm) {
        hostLoginForm.addEventListener('submit', async function (e) {
            e.preventDefault();
            const email = document.getElementById('hostEmail').value.trim();
            const password = document.getElementById('hostPassword').value.trim();

            const host = { email, password };

            const response = await fetch('http://localhost:8080/hosts/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(host)
            });

            if (response.ok) {
                const data = await response.json();
                if (data) {
                    localStorage.setItem('hostId', data.id);
                    alert("Host login successful!");
                    window.location.href = 'host-menu.html';
                } else {
                    alert("Invalid email or password for Host.");
                }
            } else {
                alert("Error connecting to server.");
            }
        });
    }

    // Client Login
    const clientLoginForm = document.getElementById('clientLoginForm');
    if (clientLoginForm) {
        clientLoginForm.addEventListener('submit', async function (e) {
            e.preventDefault();
            const email = document.getElementById('clientEmail').value.trim();
            const password = document.getElementById('clientPassword').value.trim();

            const client = { email, password };

            const response = await fetch('http://localhost:8080/clients/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(client)
            });

            if (response.ok) {
                const data = await response.json();
                if (data) {
                    localStorage.setItem('clientId', data.id);
                    alert("Client login successful!");
                    window.location.href = 'client-menu.html';
                } else {
                    alert("Invalid email or password for Client.");
                }
            } else {
                alert("Error connecting to server.");
            }
        });
    }

    // Validation helper functions
    function validateName(name) {
        return name.length >= 3;
    }

    function validateEmail(email) {
        const regex = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;
        return regex.test(email);
    }

    function validatePassword(password) {
        const regex = /^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$/;
        return regex.test(password);
    }
});
