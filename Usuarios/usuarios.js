document.addEventListener('DOMContentLoaded', function() {
    const csvData = `
ID,Nombre,Correo,Contraseña,PedidosEnCurso,PedidosCompletados
1,Pablo Toledo,tol24355@uvg.edu.gt,FCB123,Barista (capuccino grande),pedido1|pedido2|pedido3
2,Juan Salguero,sal24374@uvg.edu.gt,cuchuhueco123,Barista (Latte y cafe americano),pedido7|pedido6
3,Damian Rodriguez,rod24537@uvg.edu.gt,noviodechon123,Barista (frapuccino y frappe matcha),pedido5|pedido4|pedido8
`.trim();

    procesarCSV(csvData);
});

function procesarCSV(data) {
    const lineas = data.split('\n').slice(1);
    const usuarioActual = lineas[1].split(',');

    document.getElementById('nombreUsuario').innerText = usuarioActual[1];
    document.getElementById('correoUsuario').innerText = usuarioActual[2];

    const pedidosEnCurso = usuarioActual[4].split('|');
    const listaPedidosEnCurso = document.getElementById('listaPedidosEnCurso');
    pedidosEnCurso.forEach(pedido => {
        const div = document.createElement('div');
        div.textContent = pedido;
        listaPedidosEnCurso.appendChild(div);
    });

    const pedidosCompletados = usuarioActual[5].split('|').length;
    document.getElementById('pedidosCompletados').innerText = `Pedidos Completados: ${pedidosCompletados}`;
}