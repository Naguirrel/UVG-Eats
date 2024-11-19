document.addEventListener("DOMContentLoaded", function () {
  var swiper = new Swiper(".mySwiper", {
    effect: "coverflow",
    grabCursor: true,
    centeredSlides: true,
    loop: true,
    slidesPerView: 1,
    coverflowEffect: {
      rotate: 0,
      stretch: 0,
      depth: 100,
      modifier: 4,
      slideShadows: false
    },
    breakpoints: {
      640: {
        slidesPerView: 2
      }
    }
  });

  // Datos simulados para bebidas
  const drinkData = {
    "Mocca Frappé": { description: "Un café clásico.", price: 22 },
    "Caramelo Frappé": { description: "Con espuma de leche.", price: 23 },
    "Clásico Barista Frappé": { description: "Café con leche.", price: 22 },
    "White Chocolate Snow Frappé": { description: "Un café clásico.", price: 22 },
    "Té Chai Frappé": { description: "Con espuma de leche.", price: 23 },
    "Té Matcha Frappé": { description: "Café con leche.", price: 25 },
  };

  // Modal
  const modal = document.getElementById("drinkModal");
  const closeModal = document.querySelector(".close");
  const drinkTitle = document.getElementById("drinkTitle");
  const drinkDescription = document.getElementById("drinkDescription");
  const drinkPrice = document.getElementById("drinkPrice");
  const quantityInput = document.getElementById("quantity");
  const orderList = document.getElementById("orderList");
  const subtotalText = document.getElementById("subtotalText");
  const clearOrderButton = document.getElementById("clearOrder");
  const submitOrderButton = document.getElementById("submitOrder");
  let selectedDrink = "";
  let totalSubtotal = 0;

  document.querySelectorAll(".swiper-slide").forEach(slide => {
    slide.addEventListener("click", function () {
      const drinkName = slide.getAttribute("data-name");
      selectedDrink = drinkName;

      const drinkInfo = drinkData[drinkName];
      if (drinkInfo) {
        drinkTitle.textContent = drinkName;
        drinkDescription.textContent = drinkInfo.description;
        drinkPrice.textContent = `$${drinkInfo.price.toFixed(2)}`;
        quantityInput.value = 0;

        modal.style.display = "flex";
      } else {
        console.error(`Datos no encontrados para la bebida: ${drinkName}`);
      }
    });
  });

  closeModal.onclick = function () {
    modal.style.display = "none";
  };

  window.onclick = function (event) {
    if (event.target === modal) {
      modal.style.display = "none";
    }
  };

  // Contador
  document.getElementById("increase").addEventListener("click", function () {
    quantityInput.value = parseInt(quantityInput.value) + 1;
  });

  document.getElementById("decrease").addEventListener("click", function () {
    if (parseInt(quantityInput.value) > 0) {
      quantityInput.value = parseInt(quantityInput.value) - 1;
    }
  });

  // Agregar al pedido
  document.getElementById("addToOrder").addEventListener("click", function () {
    const quantity = parseInt(quantityInput.value);
    if (quantity > 0) {
      const drinkInfo = drinkData[selectedDrink];
      const subtotal = drinkInfo.price * quantity;

      const listItem = document.createElement("li");
      listItem.textContent = `${selectedDrink} (${quantity}) $${subtotal.toFixed(2)}`;
      orderList.appendChild(listItem);

      totalSubtotal += subtotal; // Actualiza el subtotal acumulado
      updateSubtotal();

      modal.style.display = "none"; // Cierra el modal
    } else {
      alert("Por favor, selecciona una cantidad mayor a 0.");
    }
  });

  // Actualiza el subtotal mostrado
  function updateSubtotal() {
    subtotalText.textContent = `Subtotal: Q${totalSubtotal.toFixed(2)}`;
  }

  // Limpiar el pedido
  clearOrderButton.addEventListener("click", function () {
    orderList.innerHTML = ""; // Limpia la lista de pedidos
    totalSubtotal = 0; // Resetea el subtotal
    updateSubtotal(); // Actualiza la vista
  });

  // Enviar el pedido
  submitOrderButton.addEventListener("click", function () {
    if (totalSubtotal > 0) {
      alert("Pedido enviado exitosamente!");
      // Aquí puedes añadir lógica para enviar el pedido a un servidor o procesarlo
      orderList.innerHTML = ""; // Limpia la lista de pedidos
      totalSubtotal = 0; // Resetea el subtotal
      updateSubtotal(); // Actualiza la vista
    } else {
      alert("No hay productos en el pedido.");
    }
  });
});
