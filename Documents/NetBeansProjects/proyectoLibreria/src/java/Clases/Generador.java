package Clases;

//Creado por Michael Pico
/**
 * @author Michael
 */
public class Generador {

    public Generador() {
    }

    /**
     * Genera la nav dependiendo de el tipo de usuario TipoUsuario 0: ninguno 1:
     * Usuario normal logueado 2: Ususario gestor 3: Usuario adminisitrador
     */
    public String generarNavBar(int tipoUsuario) {

        String parte1Nav
                = "  <!-- Barra de navegacion entre paginas -->\n"
                + "  <nav class=\"navbar navbar-expand-md navbar-dark bg-dark sticky-top\">\n"
                + "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n"
                + "        <span class=\"navbar-toggler-icon\"></span>\n"
                + "      </button>\n"
                + "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"inicio.html\">\n"
                + "        <i class=\"fa d-inline fa-book fa-bool\" ></i>\n"
                + "          <b>Libreria Alpes</b>\n"
                + "        </a>\n"
                + "        <ul class=\"navbar-nav mx-auto\">\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"index.jsp\">Inicio</a> </li>\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"tienda.jsp\">Tienda</a> </li>\n";

        String parte2Nav
                = "        </ul>\n"
                + "        <ul class=\"navbar-nav\">\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"login.jsp\">Log in</a> </li>\n"
                + "          <li class=\"nav-item\"> <a class=\"nav-link text-primary\" href=\"registro.jsp\">Registrate</a> </li>\n";

        String parte3Nav
                = "        </ul>\n"
                + "      </div>\n"
                + "    </div>\n"
                + "  </nav>\n"
                + "  <!-- Fin de la barra -->";

        return parte1Nav + parte2Nav + parte3Nav;
    }

    /**
     * Sobrecarga de el metodo anterior la cual le muestra su saldo a los
     * usuarios normales
     *
     * @param tipoUsuario
     * @param id
     * @return
     */
    public String generarNavBar(int tipoUsuario, int id) {

        String parte1Nav
                = "  <!-- Barra de navegacion entre paginas -->\n"
                + "  <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark sticky-top\">\n"
                + "    <div class=\"container\"> <button class=\"navbar-toggler navbar-toggler-right border-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar12\" style=\"\">\n"
                + "        <span class=\"navbar-toggler-icon\"></span>\n"
                + "      </button>\n"
                + "      <div class=\"collapse navbar-collapse\" id=\"navbar12\"> <a class=\"navbar-brand d-none d-md-block\" href=\"index.html\">\n"
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
            parte1Nav += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"historial.jsp\">Pedidos</a> </li>\n";
            parte2Nav += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"carrito.jsp\">" + "Saldo: " + Double.toString(Query.getSaldoUsuario(id)) + "€" + "</a> </li>\n";
            parte2Nav += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"cerrarSesion.jsp\">Cerrar Sesion</a> </li>\n";

            if (tipoUsuario == 3) {
                parte1Nav += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"gestionUsuarios.jsp\">Gestion Usuarios </a> </li> <!-- Dar de alta usuarios -->\n";

            }

            if (tipoUsuario == 2 || tipoUsuario == 3) {
                parte1Nav
                        += "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"gestionSaldo.jsp\">Gestion Saldo</a> </li> <!-- Gestionar Saldo -->\n"
                        + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"gestionProductos.jsp\">Gestion Productos</a> </li> <!-- Gestionar Productos -->\n"
                        + "          <li class=\"nav-item\"> <a class=\"nav-link\" href=\"gestionCompras.jsp\">Gestion Compras</a> </li> <!-- Gestionar Compras -->\n";
            }
        }

        return parte1Nav + parte2Nav + parte3Nav;
    }

    /**
     * Genera un producto de la tienda El array consiste de varias partes: parte
     * 0: link de la imagen parte 1: titulo de el producto parte 2: Categoria de
     * el producto parte 3: Precio de el producto parte 4: Valoracion de el
     * producto 5: id de el producto
     */
    public String generarProductoTienda(String[] datosProducto) {
        String producto
                = "      <!-- Inicio Producto -->\n"
                + "      <div class=\"col-md-4 mt-2\" style=\"min-width: 350px;\">\n"
                + "        <div class=\"card\">\n"
                + "          <div class=\"card-body\">\n"
                + "            <div class=\"card-img-actions w-100\" style=\"overflow: hidden;\" >\n"
                + "              <!-- Link de la imagen -->\n"
                + "              <img src=\"$imagen$\" class=\"card-img\"  style=\"width: auto;\" height=\"350\" alt=\"\">\n"
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
                + "            <h3 class=\"mb-0 font-weight-semibold\">$precio$€</h3>\n"
                + "            <div>\n"
                + "              <!-- Valoracion de el producto -->\n"
                + "              $valoracion$"
                + "            </div>\n"
                + "            <!-- Añadir a el carrito -->\n"
                + "            <form action=\"  Scripts/scriptAñadirCarrito.jsp\">\n"
                + "             <input type=\"hidden\" name=\"productoId\" value=\"" + datosProducto[5] + "\">\n"
                + "            <button type=\"submit\" class=\"btn bg-cart\"><i class=\"fa fa-cart-plus mr-2\"></i> Añadir a el carrtio</button>\n"
                + "            </form>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "      </div>\n"
                + "      <!-- Fin de el producto -->";

        String valoracion = "";

        for (int i = 0; i < Integer.parseInt(datosProducto[4]); i++) {
            valoracion += "              <i class=\"fa fa-star star\"></i>\n";
        }

        producto = producto.replace("$imagen$", datosProducto[0]);
        producto = producto.replace("$titulo$", datosProducto[1]);
        producto = producto.replace("$categoria$", datosProducto[2]);
        producto = producto.replace("$precio$", datosProducto[3]);
        producto = producto.replace("$valoracion$", valoracion);

        return producto;
    }

    /**
     * Genera un producto de carrito El array consiste de varias partes: parte
     * 0: link de la imagen parte 1: titulo de el producto parte 2: Categoria de
     * el producto parte 3: Precio de el producto parte 4: Valoracion de el
     * producto parte 5: id parte 6: cantidad
     */
    public String generarProductoCarrito(String[] datosProducto) {
        String producto
                = "<!-- Inicio Producto -->\n"
                + "              <div class=\"product\">\n"
                + "                <div class=\"row\">\n"
                + "                  <div class=\"col-md-3\">\n"
                + "                    <!-- Link de la imagen -->\n"
                + "                    <img class=\"img-fluid mx-auto d-block image\" src=\"$imagen$\" style=\"width:auto; height: 150px;\">\n"
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
                + "                          <span>$precio$€</span>\n"
                + "                        </div>\n"
                + "                      </div>\n"
                + "                    </div>\n"
                + "                  </div>\n"
                + "                </div>\n"
                + "              </div>\n"
                + "              <!-- Fin de el producto -->\n";

        producto = producto.replace("$imagen$", datosProducto[0]);
        producto = producto.replace("$titulo$", datosProducto[1]);
        producto = producto.replace("$categoria$", datosProducto[2]);
        producto = producto.replace("$precio$", datosProducto[3]);
        producto = producto.replace("$valoracion$", datosProducto[4]);
        producto = producto.replace("$cantidad$", datosProducto[6]);

        return producto;
    }

    /**
     * Genera el historial de un pedido
     *
     * @param numeroPedido
     * @param estadoPedido
     * @param infoProducto
     * @return
     */
    public String generarHistorialPedido(String numeroPedido, String estadoPedido, String infoProducto) {
        String plantilla
                = "  <div class=\"py-2\" >\n"
                + "    <div class=\"container\">\n"
                + "      <div class=\"row\">\n"
                + "        <div class=\"col-md-12\">\n"
                + "          <div class=\"row\">\n"
                + "            <div class=\"col-md-6\">\n"
                + "              <h1 class=\"\">Pedido: &numeroPedido&</h1>\n"
                + "            </div>\n"
                + "            <div class=\"col-md-6\">\n"
                + "              <h1 class=\"text-right\" >Estado: &estadoPedido&</h1>\n"
                + "            </div>\n"
                + "          </div>\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"table table-bordered\">\n"
                + "              <thead class=\"thead-dark\">\n"
                + "                <tr>\n"
                + "                  <th colspan=\"5\">Productos:&nbsp;</th>\n"
                + "                </tr>"
                + "                <tr>\n"
                + "                  <th>Nombre</th>\n"
                + "                  <th>Categoria</th>\n"
                + "                  <th>Precio Unidad</th>\n"
                + "                  <th>Cantidad</th>\n"
                + "                  <th>Precio Total</th>\n"
                + "                </tr>\n"
                + "              </thead>\n"
                + "              <tbody>\n"
                + "                &infoProductos&"
                + "              </tbody>\n"
                + "            </table>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>\n"
                + "  </div>\n";

        return plantilla.replace("&numeroPedido&", numeroPedido).replace("&estadoPedido&", estadoPedido).replace("&infoProductos&", infoProducto);

    }
    
    public String generarListaUsuarios(String usuarios){
        String plantilla = "  <div class=\"py-2\" >\n" +
"    <div class=\"container\">\n"
                + "      <div class=\"row\">\n"
                + "        <div class=\"col-md-12\">\n"
                + "          <div class=\"table-responsive\">\n"
                + "            <table class=\"table table-bordered\">\n"
                + "              <thead class=\"thead-dark\">\n"
                + "                <tr>\n"
                + "                  <th colspan=\"5\" style=\"\">Usuarios</th>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                  <th>ID</th>\n"
                + "                  <th>Correo</th>\n"
                + "                  <th>Saldo</th>\n"
                + "                  <th>Tipo</th>\n"
                + "                </tr>\n"
                + "              </thead>\n"
                + "              <tbody>\n"
                + "                &tablas&"
                + "              </tbody>\n"
                + "            </table>\n"
                + "          </div>\n"
                + "        </div>\n"
                + "      </div>\n"
                + "    </div>\n"
                + "  </div>";
        
        return plantilla.replace("&tablas&", usuarios);
    }

    /**
     * Genera un resumen de pedido basandose en los datos recibidos El array
     * consiste de varias partes: parte 0: saldo parte 1: totalproducto 2: envio
     * 3: totalpedido 4: saldofinal
     */
    public String generarResumenPedido(double[] datosPedido) {
        String resumen = "<!-- Resumen pedido -->\n"
                + "            <div class=\"summary\">\n"
                + "              <h3>Resumen</h3>\n"
                + "              <div class=\"summary-item\"><span class=\"text\">Saldo de la cuenta</span><span class=\"price\">$saldo$€</span></div>\n"
                + "              <div class=\"summary-item\"><span class=\"text\">Total productos</span><span class=\"price\">$totalproductos€</span></div>\n"
                + "              <div class=\"summary-item\"><span class=\"text\">Envio</span><span class=\"price\">$envio$€</span></div>\n"
                + "              <div class=\"summary-item\"><span class=\"text\">Total pedido</span><span class=\"price\">$totalpedido$€</span></div>\n"
                + "              <div class=\"summary-item mt-2\"><span class=\"text\">Saldo de la cuenta final</span><span class=\"price\">$saldofinal$€</span></div>\n"
                + "              <form action=\"Scripts/scriptPagar.jsp\">\n"
                + "                <button type=\"submit\" class=\"btn btn-primary btn-lg btn-block\">Pagar</button>\n"
                + "              </form>\n"
                + "              <form action=\"Scripts/scriptBorrarCarrito.jsp\">\n"
                + "                <button type=\"submit\" class=\"btn btn-primary btn-lg btn-block\">Limpiar Carrito</button>\n"
                + "              </form>\n"
                + "            </div>";

        resumen = resumen.replace("$saldo$", Double.toString(datosPedido[0]));
        resumen = resumen.replace("$totalproductos", Double.toString(datosPedido[1]));
        resumen = resumen.replace("$envio$", Double.toString(datosPedido[2]));
        resumen = resumen.replace("$totalpedido$", Double.toString(datosPedido[3]));
        resumen = resumen.replace("$saldofinal$", Double.toString(datosPedido[4]));

        return resumen;
    }

    /**
     * Imprime un mensaje de error
     *
     */
    public String generarError(String mensaje) {

        String error = "<p class=\"text-monospace text-danger\" >$mensaje$</p>\n";

        return error.replace("$mensaje$", mensaje);
    }

    /**
     * Carga todos los productos de la tienda desde la base de datos
     */
    public String cargarProductosTienda() {
        String respuesta = "";
        for (int i = 1; i < Query.getCantidadProducos() + 1; i++) {
            String[] infoProducto = Query.getProducto(i);
            if (infoProducto != null) {
                respuesta += generarProductoTienda(infoProducto);
            } else {
                System.out.println("error con id: " + i);
            }
        }

        return respuesta;
    }
    
    

}
