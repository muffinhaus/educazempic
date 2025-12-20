async function login() {
  const username = document.getElementById('username').value;
  const pass = document.getElementById('pass').value;
  const errorEl = document.getElementById('error');
  errorEl.textContent = '';

  try {
    const res = await fetch('http://127.0.0.1:8080/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ username, pass }),
    });

    if (!res.ok) {
      const data = await res.json();
      errorEl.textContent = data.error;
      return;
    }

    const data = await res.json();
    if (data.role === 'ROLE_ADMIN') {
      window.location.href = 'admin.html';
    } else {
      window.location.href = 'student.html';
    }
  } catch (err) {
    errorEl.textContent = 'Error conexión';
  }
}
