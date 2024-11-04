// Función para crear una nueva cuenta y guardar los datos en un archivo CSV
function crearCuenta() {
    const nombre = document.getElementById("nombre").value.trim();
    const email = document.getElementById("new-email").value.trim();
    const password = document.getElementById("new-password").value.trim();

    if (!nombre || !email || !password) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const pedidosEnCurso = "[]";
    const pedidosCompletados = "[]";

    const usuarioCSV = `${nombre},${email},${password},${pedidosEnCurso},${pedidosCompletados}\n`;

    let csvContent = localStorage.getItem("usuariosCSV") || "Nombre,Usuario,Contraseña,PedidosEnCurso,PedidosCompletados\n";
    csvContent += usuarioCSV;
    localStorage.setItem("usuariosCSV", csvContent);

    alert("Cuenta creada y datos guardados en el archivo CSV.");
    limpiarFormularioCrearCuenta();
}

// Función para limpiar el formulario de creación de cuenta
function limpiarFormularioCrearCuenta() {
    document.getElementById("nombre").value = "";
    document.getElementById("new-email").value = "";
    document.getElementById("new-password").value = "";
}

// Función para iniciar sesión
function login() {
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    const csvContent = localStorage.getItem("usuariosCSV");
    if (!csvContent) {
        alert("No hay usuarios registrados.");
        return;
    }

    const lines = csvContent.split("\n");
    const usuario = lines.find(line => {
        const [nombre, usuarioEmail, usuarioPassword] = line.split(",");
        return usuarioEmail === email && usuarioPassword === password;
    });

    if (usuario) {
        alert("Inicio de sesión exitoso");
        // Redirige a la nueva página donde se muestran los datos del usuario
        window.location.href = "Menú_1.html";
    } else {
        alert("Correo o contraseña incorrectos.");
    }
}
