document.addEventListener("DOMContentLoaded", function() {
    const csvPath = "usuarios.csv"; // Ruta del archivo CSV
    const currentUser = "usuario1"; // Nombre de usuario del login (simulación)

    fetch(csvPath)
        .then(response => response.text())
        .then(data => {
            const rows = data.split("\n").slice(1); // Ignorar encabezado del CSV
            const userTableBody = document.getElementById("userTableBody");

            rows.forEach(row => {
                const columns = row.split(",");
                const [nombre, apellido, carnet, usuario, contrasena, pedidosCompletados, pedidosEnCurso] = columns;

                if (usuario.trim() === currentUser) { // Filtrar por usuario logueado
                    const userDetails = [
                        { atributo: "Nombre", valor: `${nombre} ${apellido}` },
                        { atributo: "Carnet", valor: carnet },
                        { atributo: "Usuario", valor: usuario },
                        { atributo: "Contraseña", valor: contrasena },
                        { atributo: "Pedidos Completados", valor: pedidosCompletados },
                        { atributo: "Pedidos en Curso", valor: pedidosEnCurso }
                    ];

                    document.getElementById("userName").textContent = `${nombre} ${apellido}`;

                    userDetails.forEach(detail => {
                        const tr = document.createElement("tr");
                        tr.innerHTML = `<td>${detail.atributo}</td><td>${detail.valor}</td>`;
                        userTableBody.appendChild(tr);
                    });
                }
            });
        })
        .catch(error => console.error("Error al leer el archivo CSV:", error));
});
