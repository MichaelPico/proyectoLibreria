package Clases;

//Creado por Michael Pico
/**
 *
 * @author Michael
 */
public class Generador {

    public Generador() {
    }

    /**TipoUsuario
     * 0: ninguno
     * 1: Usuario normal logueado
     * 2: Ususario gestor
     * 3: Usuario adminisitrador
     */
    public String generarNavBar(int tipoUsuario) {

        String parte1Nav
                = "  <!-- Barra de navegacion entre paginas -->\n"
                + "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\">\n"
                + "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n"
                + "        <span class=\"navbar-toggler-icon\"></span>\n"
                + "      </button>\n"
                + "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"inicio.html\">\n"
                + "        <i class=\"fa d-inline fa-book fa-bool\" ></i>\n"
                + "          <b>Libreria Alpes</b>\n"
                + "        </a>\n"
                + "        <ul class=\"navbar-nav mx-auto\">\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"index.jsp\">Inicio</a> </li>\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"tienda.jsp\">Tienda</a> </li>\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"carrito.jsp\">Carrito</a> </li>\n";

        String parte2Nav
                = "        </ul>\n"
                + "        <ul class=\"navbar-nav\">\n";
                        
        String parte3Nav 
                = "        </ul>\n"
                + "      </div>\n"
                + "    </div>\n"
                + "  </nav>\n"
                + "  <!-- Fin de la barra -->";
        
        if (tipoUsuario > 0) {
            
            parte2Nav += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"cerrarSesion.jsp\">Cerrar Sesion</a> </li>\n";
        } else {
            parte2Nav += ""
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.jsp\">Log in</a> </li>\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"registro.jsp\">Registrate</a> </li>\n";
        }

        if (tipoUsuario == 3) {
            parte1Nav += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"usuarios.jsp\">Gestionar Usuarios </a> </li> <!-- Dar de alta usuarios -->\n";
                                    
        }

        if (tipoUsuario == 2 || tipoUsuario == 3) {
            parte1Nav
                    += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"saldo.jsp\">Gestionar Saldo</a> </li> <!-- Gestionar Saldo -->\n"
                    + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"compras.jsp\">Gestionar Compras</a> </li> <!-- Gestionar Compras -->\n";
        }

        return parte1Nav + parte2Nav + parte3Nav;
    }

    /*El array consiste de varias partes:
    * parte 0: link de la imagen
    * parte 1: titulo de el producto
    * parte 2: Categoria de el producto
    * parte 3: Precio de el producto
    * parte 4: Valoracion de el producto
    * parte 5: id
     */
    public String generarProductoTienda(String[] datosProducto) {
        String producto
                = "      <!-- Inicio Producto -->\n"
                + "      <div class=\"col-md-4 mt-2\">\n"
                + "        <div class=\"card\">\n"
                + "          <div class=\"card-body\">\n"
                + "            <div class=\"card-img-actions\">\n"
                + "              <!-- Link de la imagen -->\n"
                + "              <img src=\"$imagen$\" class=\"card-img img-fluid\" width=\"96\" height=\"350\" alt=\"\">\n"
                + "            </div>\n"
                + "          </div>\n"
                + "          <div class=\"card-body bg-light text-center\">\n"
                + "            <div class=\"mb-2\">\n"
                + "              <h6 class=\"font-weight-semibold mb-2\">\n"
                + "                <!-- Titulo de el producto -->\n"
                + "                <label class=\"text-default mb-2\" data-abc=\"true\">$titulo$</label>\n"
                + "              </h6>\n"
                + "              <!-- Categoria -->\n"
                + "              <label href=\"#\" class=\"text-muted\" data-abc=\"true\">$categoria$</label>\n"
                + "            </div>\n"
                + "            <!-- Precio de el producto -->\n"
                + "            <h3 class=\"mb-0 font-weight-semibold\">$precio$</h3>\n"
                + "            <div>\n"
                + "              <!-- Valoracion de el producto -->\n"
                + "              $valoracion$"
                + "            </div>\n"
                + "            <!-- Añadir a el carrito -->\n"
                + "            <button type=\"button\" class=\"btn bg-cart\"><i class=\"fa fa-cart-plus mr-2\"></i> Añadir a el carrtio</button>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "      </div>\n"
                + "      <!-- Fin de el producto -->";
        
        String valoracion = "";
        
        for (int i = 0; i < Integer.valueOf(datosProducto[4]); i++){
            valoracion += "              <i class=\"fa fa-star star\"></i>\n";
        }
        
        producto = producto.replace("$imagen$", datosProducto[0]);
        producto = producto.replace("$titulo$", datosProducto[1]);
        producto = producto.replace("$categoria$", datosProducto[2]);
        producto = producto.replace("$precio$", datosProducto[3]);
        producto = producto.replace("$valoracion$", valoracion);

        return producto;
    }

    /*El array consiste de varias partes:
    * parte 0: link de la imagen
    * parte 1: titulo de el producto
    * parte 2: Categoria de el producto
    * parte 3: Precio de el producto
    * parte 4: Valoracion de el producto
    * parte 5: id
    * parte 6: cantidad
     */
    public String generarProductoCarrito(String[] datosProducto) {
        String producto
                = "<!-- Inicio Producto -->\n"
                + "              <div class=\"product\">\n"
                + "                <div class=\"row\">\n"
                + "                  <div class=\"col-md-3\">\n"
                + "                    <!-- Link de la imagen -->\n"
                + "                    <img class=\"img-fluid mx-auto d-block image\" src=\"$imagen$\">\n"
                + "                  </div>\n"
                + "                  <div class=\"col-md-8\">\n"
                + "                    <div class=\"info\">\n"
                + "                      <div class=\"row\">\n"
                + "                        <div class=\"col-md-5 product-name\">\n"
                + "                          <div class=\"product-name\">\n"
                + "                            <!-- Titulo de el producto -->\n"
                + "                            <label>$titulo$</label>\n"
                + "                            <div class=\"product-info\">\n"
                + "                              <!-- Categoria -->\n"
                + "                              <div>Categoria: <span class=\"value\">$categoria$</span></div>\n"
                + "                              <!-- Valoracion de el producto -->\n"
                + "                              <div>Valoracion: <span class=\"value\">$valoracion$ estrellas</span></div>\n"
                + "                            </div>\n"
                + "                          </div>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-md-4 quantity\">\n"
                + "                          <!-- Cantidad -->\n"
                + "                          <label for=\"quantity\">Cantidad:</label>\n"
                + "                          <label id=\"text\" class=\"form-control quantity-input\">$cantidad$</label>\n"
                + "                        </div>\n"
                + "                        <div class=\"col-md-3 price\">\n"
                + "                          <!-- Precio de el producto -->\n"
                + "                          <span>$precio$</span>\n"
                + "                        </div>\n"
                + "                      </div>\n"
                + "                    </div>\n"
                + "                  </div>\n"
                + "                </div>\n"
                + "              </div>\n"
                + "              <!-- Fin de el producto -->";
        
        producto = producto.replace("$imagen$", datosProducto[0]);
        producto = producto.replace("$titulo$", datosProducto[1]);
        producto = producto.replace("$categoria$", datosProducto[2]);
        producto = producto.replace("$precio$", datosProducto[3]);
        producto = producto.replace("$valoracion$", datosProducto[4]);
        producto = producto.replace("$cantidad$", datosProducto[6]);
        
        return producto;
    }
    
    /*El array consiste de varias partes:
    * parte 0: saldo
    * parte 1: totalproducto
    * parte 2: descuento
    * parte 3: envio
    * parte 4: totalpedido
    * parte 5: saldofinal
     */
    public String generarResumenPedido(double[] datosPedido){
        String resumen = "<!-- Resumen pedido -->\n" +
"            <div class=\"summary\">\n" +
"              <h3>Resumen</h3>\n" +
"              <div class=\"summary-item\"><span class=\"text\">Saldo de la cuenta</span><span class=\"price\">$saldo$€</span></div>\n" +
"              <div class=\"summary-item\"><span class=\"text\">Total productos</span><span class=\"price\">$totalproductos€</span></div>\n" +
"              <div class=\"summary-item\"><span class=\"text\">Descuento</span><span class=\"price\">$descuento$€</span></div>\n" +
"              <div class=\"summary-item\"><span class=\"text\">Shipping</span><span class=\"price\">$envio$€</span></div>\n" +
"              <div class=\"summary-item\"><span class=\"text\">Total pedido</span><span class=\"price\">$totalpedido$€</span></div>\n" +
"              <div class=\"summary-item mt-2\"><span class=\"text\">Saldo de la cuenta final</span><span class=\"price\">$saldofinal$€</span></div>\n" +
"              <button type=\"button\" class=\"btn btn-primary btn-lg btn-block\">Pagar</button>\n" +
"            </div>";
        
        resumen = resumen.replace("$saldo$", Double.toString(datosPedido[0]));
        resumen = resumen.replace("$totalproductos", Double.toString(datosPedido[1]));
        resumen = resumen.replace("$descuento$", Double.toString(datosPedido[2]));
        resumen = resumen.replace("$envio$", Double.toString(datosPedido[3]));
        resumen = resumen.replace("$totalpedido$", Double.toString(datosPedido[4]));
        resumen = resumen.replace("$saldofinal$", Double.toString(datosPedido[5]));
        
        return resumen;
    }
    
    public String generarError(String mensaje){
        
        String error = "<p class=\"text-monospace text-danger\" >$mensaje$</p>\n";
        
        return error.replace("$mensaje$", mensaje);
    }
}
