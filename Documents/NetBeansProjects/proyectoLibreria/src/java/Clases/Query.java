package Clases;

import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;

public class Query {
    
    public Query() {
    }

    //GET
    /**
     * El array consiste de varias partes: parte 0: link de la imagen parte 1:
     * titulo de el producto parte 2: Categoria de el producto parte 3: Precio
     * de el producto parte 4: Valoracion de el producto parte 5: id
     */
    public static String[] getProducto(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from productos where id = " + id);
            while (rs.next()) {
                String titulo = rs.getString(2);
                String categoria = rs.getString(3);
                String precio = Double.toString(rs.getDouble(4));
                String valoracion = Integer.toString(rs.getInt(5));
                String imagen = rs.getString(6);
                String idString = Integer.toString(rs.getInt(1));

                //Metodos que cierran toodo antes de un return
                rs.close();
                stmt.close();
                con.close();
                
                return new String[]{imagen, titulo, categoria, precio, valoracion, idString};
            }
            con.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    /**
     * Obtiene la cantidad de productos que hay en la table de productos
     */
    public static int getCantidadProducos() {
        
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM `productos`;");
            while (rs.next()) {
                
                respuesta = rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    /**
     * Obtiene el tipo de usuario
     *
     */
    public static int getTipoUsuario(String correo) {
        
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT tipo FROM `usuarios` where correo='" + correo + "'");
            while (rs.next()) {
                
                respuesta = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    /**
     * Devuelve un String con las categorias existentes
     *
     * @return
     */
    public static String getCategorias() {
        
        String respuesta = "";
        String plantilla = "<option>&Categoria&</option>\n";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT categoria FROM productos;");
            while (rs.next()) {
                respuesta += plantilla.replace("&Categoria&", rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    /**
     * Obtiene el id de el usuario
     */
    public static int getIdUsuario(String correo) {
        
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id FROM `usuarios` where correo='" + correo + "'");
            while (rs.next()) {
                
                respuesta = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    /**
     * Obtiene el saldo de un usuario
     */
    public static double getSaldoUsuario(int id) {
        
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT saldo FROM `usuarios` where id='" + id + "'");
            while (rs.next()) {
                
                respuesta = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    /**
     * El envio se calcula siendo 5 euros por producto, este metodo se usa para
     * calcular cuantos productos tendra el envio
     *
     * @param idUsuario
     * @return
     */
    public static int getCantidadProductosCarrito(int idUsuario) {
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(c.cantidad) FROM `carrito` c where c.idCliente = " + idUsuario + ";");
            while (rs.next()) {
                respuesta = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    /**
     * Calcula y devuelve el precio total de todos los productos de el carrtio
     *
     * @param idUsuario
     * @return
     */
    public static double getPrecioTotalProductosCarrtio(int idUsuario) {
        
        double respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(c.cantidad*p.precio) as precioTotal FROM `carrito` c JOIN `productos` p ON c.idProducto = p.id where idCliente = " + idUsuario + ";");
            while (rs.next()) {
                respuesta = rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    /**
     * Devuelve cuantos pedidos tiene el usuario en el historial
     *
     * @param idUsuario
     * @return
     */
    public static int getNumeroHistorialPedido(int idUsuario) {
        
        int respuesta = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT idPedido from historial_pedidos where idUsuario = " + idUsuario + ";");
            while (rs.next()) {
                respuesta++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    /**
     * String que obtiene la lista de usuarios
     *
     * @return
     */
    public static String getUsuariosLista() {
        String respuesta = "";
        Generador a = new Generador();
        
        String tablaModelo
                = "                <tr>\n"
                + "                  <td>&idUsuario&</td>\n"
                + "                  <td>&correoUsuario&</td>\n"
                + "                  <td>&saldoUsuario&€</td>\n"
                + "                  <td>&tipoUsuario&</td>\n"
                + "                </tr>\n";
        
        String filas = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECt id, correo, saldo, tipo FROM `usuarios`;");
            while (rs.next()) {
                respuesta += tablaModelo.replace("&idUsuario&", Integer.toString(rs.getInt(1))).replace("&correoUsuario&", rs.getString(2)).replace("&saldoUsuario&", Double.toString(rs.getDouble(3))).replace("&tipoUsuario&", Integer.toString(rs.getInt(4)));
            }
            
        } catch (Exception e) {
            respuesta = e.getMessage();
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    /**
     * Devuelve un string con las tablas de titulo producto y cantidad
     *
     * @param idUsuario
     * @param idPedido
     * @return
     */
    public static String getFilasProductoHistorial(int idUsuario, int idPedido) {
        
        String respuesta = "";
        
        String tablaModelo
                = "                <tr>\n"
                + "                  <td>&nombreProducto&</td>\n"
                + "                  <td>&categoria&</td>\n"
                + "                  <td>&precioUnidad&€</td>\n"
                + "                  <td>&cantidadProducto&</td>\n"
                + "                  <td>&precioTotal&€</td>\n"
                + "                </tr>\n";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.titulo, h.cantidad, p.categoria, p.precio FROM historial_pedidos h join productos p on h.producto = p.id WHERE idUsuario = " + idUsuario + " and idPedido = " + idPedido + ";");
            while (rs.next()) {
                respuesta += tablaModelo.replace("&nombreProducto&", rs.getString(1)).replace("&cantidadProducto&", Integer.toString(rs.getInt(2))).replace("&categoria&", rs.getString(3)).replace("&precioUnidad&", Double.toString(rs.getDouble(4))).replace("&precioTotal&", Double.toString(Math.round((rs.getDouble(4) * rs.getInt(2)) * 100.0) / 100.0));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }

    //BOOLEANOS
    /**
     * Devuelve true si el saldo es mayor a el precio fianal
     *
     * @param idUsuario
     * @return
     */
    public static boolean haySaldoSuficiente(int idUsuario) {
        
        double saldoCliente = 0;
        double totalProducto = 0;
        double envio = 0;
        double totalPedido = 0;
        double saldoFinal = 0;
        Generador generarCodigo = new Generador();
        
        saldoCliente = getSaldoUsuario(idUsuario);
        totalProducto = getPrecioTotalProductosCarrtio(idUsuario);
        envio = getCantidadProductosCarrito(idUsuario) * 5.00;
        totalPedido = totalProducto + envio;
        saldoFinal = Math.round((saldoCliente - totalPedido) * 100.0) / 100.0;;
        
        if (saldoFinal > 0) {
            return true;
        }
        
        return false;
    }

    /**
     * Comprueba que existe el usuario en la table
     */
    public static boolean existeUsuario(String correo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM `usuarios` where correo='" + correo + "'");
            while (rs.next()) {
                if (rs.getInt(1) > 0) {

                    //Metodos que cierran toodo antes de un return
                    rs.close();
                    stmt.close();
                    con.close();
                    
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Comprueba que existe el usuario en la tabla
     */
    public static boolean existeUsuario(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM `usuarios` where id='" + id + "'");
            while (rs.next()) {
                if (rs.getInt(1) > 0) {

                    //Metodos que cierran toodo antes de un return
                    rs.close();
                    stmt.close();
                    con.close();
                    
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Comprueba que la contraseña ela que corresponde con el usuario
     */
    public static boolean contraseñaCorrecta(String correo, String pass) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM `usuarios` where correo='" + correo + "' and pass='" + pass + "'");
            while (rs.next()) {
                if (rs.getInt(1) > 0) {

                    //Metodos que cierran toodo antes de un return
                    rs.close();
                    stmt.close();
                    con.close();
                    
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Devuelve true si el producto se encuentra en el carrito
     *
     * @param idUsuario
     * @param idProducto
     * @return
     */
    public static boolean estaElProductoEnElCarrito(int idUsuario, int idProducto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `carrito` WHERE idCliente = " + idUsuario + " and idProducto = " + idProducto + ";");
            int contador = 0;
            while (rs.next()) {
                contador++;
                if (contador > 0) {

                    //Metodos que cierran toodo antes de un return
                    rs.close();
                    stmt.close();
                    con.close();
                    
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Aumenta en uno la cantidad de el producto en el carrito
     *
     * @param idUsuario
     * @param idProducto
     */
    public static void aumentarCantidadProducto(int idUsuario, int idProducto) {
        if (idUsuario > 0) {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE `carrito` SET cantidad = cantidad + 1 WHERE idCliente = " + idUsuario + " and idProducto = " + idProducto + ";");
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
    }

    /**
     * Hace un insert de usuario
     *
     * @param correo
     * @param pass
     * @param saldo
     * @param tipo
     */
    public static void insertUsuario(String correo, String pass, double saldo, int tipo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `usuarios`(`correo`, `pass`, `saldo`, `tipo`) VALUES ('" + correo + "','" + pass + "','" + Double.toString(saldo) + "','" + Integer.toString(tipo) + "')");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un usuario segun su id
     *
     * @param id
     * @param correo
     * @param pass
     * @param saldo
     * @param tipo
     */
    public static void updateUsuario(int id, String correo, String pass, double saldo, int tipo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `usuarios` SET `correo`='" + correo + "',`pass`='" + pass + "',`saldo`='" + Double.toString(saldo) + "',`tipo`='" + Integer.toString(tipo) + "' WHERE id = " + id + ";");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Borra un usuario segun su id
     *
     * @param id
     */
    public static void dropUsuario(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `usuarios` WHERE id = " + id + ";");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Añade un producto a la tabla carritos
     *
     */
    public static void añadirProductoCarrito(int idUsuario, int idProducto) {
        if (idUsuario > 0) {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO `carrito`(`idCliente`, `idProducto`, `cantidad`) VALUES ('" + idUsuario + "','" + idProducto + "','1')");
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Crea un producto segun los parametros
     *
     * @param titulo
     * @param categoria
     * @param precio
     * @param valoracion
     * @param imagen
     */
    public static void crearProducto(String titulo, String categoria, double precio, int valoracion, String imagen) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `productos`(`titulo`, `categoria`, "
                    + "`precio`, `valoracion`, `imagen`) VALUES ('" + titulo + "',"
                    + "'" + categoria + "','" + Double.toString(precio) + "','" + Integer.toString(valoracion) + "','" + imagen + "')");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Borra un producto segun el titulo
     *
     * @param titulo
     */
    public static void borrarProducto(String titulo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `productos` WHERE titulo = '" + titulo + "'");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void actualizarSaldo(int idUsuario, double saldo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `usuarios` SET `saldo`='" + Double.toString(saldo) + "' WHERE id = '" + Integer.toString(idUsuario) + "';");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Añade el pedido a el historial
     *
     * @param idUsuario
     */
    public static void añadirPedidoHistorial(int idUsuario) {
        int idPedido = getNumeroHistorialPedido(idUsuario) + 1;
        if (idUsuario > 0) {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
                Statement stmt = con.createStatement();
                Statement insert = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT p.id, c.cantidad FROM `carrito` c JOIN `productos` p ON c.idProducto = p.id where c.idCliente = " + idUsuario + ";");
                while (rs.next()) {
                    insert.executeUpdate("INSERT INTO `historial_pedidos`(`idUsuario`, `idPedido`,"
                            + " `producto`, `cantidad`, `estado`) VALUES ('" + Integer.toString(idUsuario) + "','" + Integer.toString(idPedido) + "','" + Integer.toString(rs.getInt(1)) + "','" + Integer.toString(rs.getInt(2)) + "','Proceso');");
                }
            } catch (Exception e) {
                writeToFile(e.getMessage(), "C:\\Users\\micha\\Desktop\\a.txt");
            }
        }
    }

    /**
     * Actualiza el saldo de el usuario despues de la compra
     *
     * @param idUsuario
     */
    public static void actualizarSaldo(int idUsuario) {
        
        double saldoCliente = 0;
        double totalProducto = 0;
        double envio = 0;
        double totalPedido = 0;
        double saldoFinal = 0;
        Generador generarCodigo = new Generador();
        
        saldoCliente = getSaldoUsuario(idUsuario);
        totalProducto = getPrecioTotalProductosCarrtio(idUsuario);
        envio = getCantidadProductosCarrito(idUsuario) * 5.00;
        totalPedido = totalProducto + envio;
        saldoFinal = Math.round((saldoCliente - totalPedido) * 100.0) / 100.0;;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `usuarios` SET`saldo`='" + saldoFinal + "' WHERE id = " + idUsuario + ";");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Borra todo el carrtio al realizar una compra
     *
     * @param idUsuario
     */
    public static void borrarCarrito(int idUsuario) {
        if (idUsuario > 0) {
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "escritura", "CG/bnNk(S/SLo8Cq");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM `carrito` WHERE idCliente = " + idUsuario + ";");
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Obtiene los datos de los productos de el carrtio de el usuario y llama a
     * el metodo que los genera. devuelve un string con todos los productos de
     * el carrtio
     *
     */
    public static String dibujarProductosCarrito(int idUsuario) {
        String respuesta = "";
        Generador a = new Generador();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.imagen, p.titulo, p.categoria, p.precio, p.valoracion, c.cantidad FROM `carrito` c JOIN `productos` p ON c.idProducto = p.id where c.idCliente = " + idUsuario + ";");
            while (rs.next()) {
                String[] partes = {rs.getString(1), rs.getString(2), rs.getString(3), Double.toString(rs.getDouble(4)), Integer.toString(rs.getInt(5)), null, Integer.toString(rs.getInt(6))};
                respuesta += a.generarProductoCarrito(partes);
            }
            
        } catch (Exception e) {
            respuesta = e.getMessage();
            System.out.println(e.getMessage());
        }
        
        if (respuesta.equals("")) {
            respuesta
                    = "              <div class=\"pt-5\" >\n"
                    + "                <h3 class=\"text-center\">Parece que no has añadido nada a el carrito, deberias ir a la tienda y añadir algunos libros.</h3>\n"
                    + "              </div>";
        }
        
        return respuesta;
    }

    /**
     * Obtiene los datos de el cliente y de su pedido y dibuja el resumen de su
     * pedido
     *
     * @param idUsuario
     * @return
     */
    public static String dibujarResumenCarrito(int idUsuario) {
        String respuesta = "";
        double saldoCliente = 0;
        double totalProducto = 0;
        double envio = 0;
        double totalPedido = 0;
        double saldoFinal = 0;
        Generador generarCodigo = new Generador();
        
        saldoCliente = getSaldoUsuario(idUsuario);
        totalProducto = getPrecioTotalProductosCarrtio(idUsuario);
        envio = getCantidadProductosCarrito(idUsuario) * 5.00;
        totalPedido = totalProducto + envio;
        saldoFinal = Math.round((saldoCliente - totalPedido) * 100.0) / 100.0;;
        
        double[] datos = {saldoCliente, totalProducto, envio, totalPedido, saldoFinal};
        respuesta = generarCodigo.generarResumenPedido(datos);
        
        return respuesta;
    }

    /**
     * Obtiene el historial de pedidos de el cliente y lo dibuja en el historial
     * de pedidos
     *
     * @param idUsuario
     * @return
     */
    public static String dibujarHistorialPedidosTotal(int idUsuario) {
        
        String respuesta = "";
        int contador = 0;
        
        int numeroPedido = 0;
        String estadoPedido = "";
        String infoProducto = "";
        
        Generador generaCodigo = new Generador();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT h.idPedido, h.estado FROM historial_pedidos h join productos p on h.producto = p.id WHERE idUsuario = " + idUsuario + " GROUP by idPedido;");
            while (rs.next()) {
                contador++;
                numeroPedido = rs.getInt(1);
                estadoPedido = rs.getString(2);
                infoProducto = getFilasProductoHistorial(idUsuario, numeroPedido);
                respuesta += generaCodigo.generarHistorialPedido(Integer.toString(numeroPedido), estadoPedido, infoProducto);
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if (contador == 0) {
            respuesta = "          <p class=\"lead text-center\" >Parece que no has comprado nada, deberias ir a la tienda y comprar unos libros, nunca vienen mal.</p>";
        }
        return respuesta;
    }

    /**
     * Carga todos los productos de la tienda desde la base de datos
     */
    public static String dibujarProductosTiendaFiltrada(String nombre, String categoria, double maximo) {
        String respuesta = "";
        
        String filtroNombre = "";
        String filtroCategoria = "";
        String filtroMaximo = " precio < " + maximo + ";";
        
        if (!nombre.equals("")) {
            filtroNombre = " titulo like '%" + nombre + "%' and";
        }
        
        if (!categoria.equals("Todas")) {
            filtroCategoria = " categoria = '" + categoria + "' and";
        }
        
        String query = "select id from productos where" + filtroNombre + filtroCategoria + filtroMaximo;
        writeToFile(query, "C:\\Users\\micha\\Desktop\\b.txt");
        
        Generador generaCodigo = new Generador();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectolibreria", "lectura", "]dsS0omVISMl!CGx");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String[] infoProducto = Query.getProducto(rs.getInt(1));
                respuesta += generaCodigo.generarProductoTienda(infoProducto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public static void writeToFile(String text, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(text);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
