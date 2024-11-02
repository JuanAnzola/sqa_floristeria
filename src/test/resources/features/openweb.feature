@successful
Feature: Visualización y selección de productos de una categoría

  Scenario: Ver productos de la categoría Agradecimientos
    Given El "usuario" ingresa a la pagina
    When El usuario navega a la categoría "Agradecimientos"
    When El usuario selecciona el producto "MDF 00015" de la lista y hace clic en agregar al carrito
    And El usuario selecciona el producto "MDF 00020" de la lista y hace clic en agregar al carrito
    Then El usuario verifica que el carro tiene los productos seleccionados
