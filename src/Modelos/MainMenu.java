package Modelos;

import Modelos.Categories.Category;
import Modelos.Products.Product;
import Modelos.Users.User;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public MainMenu(){

    }

    private static final User userService = new User();
    private static final Product productService = new Product();
    private static final Category categoryService = new Category();
    static Scanner scanner = new Scanner(System.in);

    public static void iniciarMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    crearProducto();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    crearCategoria();
                    break;
                case 6:
                    listarCategorias();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    public static void mostrarMenu() {
        System.out.println("-------------------");
        System.out.println("*** Menú Principal Gestock ***:");
        System.out.println("1. Crear usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Crear producto");
        System.out.println("4. Listar productos");
        System.out.println("5. Crear categoría");
        System.out.println("6. Listar categorías");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void crearUsuario() {
        System.out.println("-------------------");
        System.out.println("*** Creación de usuario ***");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        int ID = userService.listar().size() + 1;
        User user = new User(ID, name, email, password);
        userService.crear(user);
        System.out.println("Usuario creado exitosamente.");
    }

    public static void listarUsuarios() {
        System.out.println("-------------------");
        System.out.println("*** Listar usuarios registrados ***");
        List<User> usuarios = userService.listar();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (User user : usuarios) {
                System.out.println("ID: " + user.getId() + ", Nombre: " + user.getName() + ", Email: " + user.getEmail());
            }
        }
    }

    public static void crearProducto() {
        System.out.println("-------------------");
        System.out.println("*** Creación de productos ***");
        System.out.print("Nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Imagen del producto: ");
        String image = scanner.nextLine();
        System.out.print("Precio: ");
        Double price = scanner.nextDouble();
        System.out.println("Ingrese cuantas unidades de este producto va a registrar: ");
        int stock = scanner.nextInt();
        // TODO almacenar el producto en una categoria
        scanner.nextLine();


        if (categoryService.listar().isEmpty()){
            System.out.println("Debido a que no hay categorias registradas, debe registrar al menos una categoría para almacenar este producto.");
            crearCategoria();
        }
        System.out.println();
        listarCategorias();
        System.out.println("Digite el ID de la categoría del producto: ");
        int selectedCategory = scanner.nextInt();
        scanner.nextLine();

        List<Product> products = productService.listar();
        int nuevoId = products.size() + 1;

        Product product = new Product(nuevoId, name, description, image, price, stock, categoryService.buscarPorId(selectedCategory));
        productService.crear(product);
        System.out.println("Producto creado y almacenado exitosamente.");
        categoryService.addProudctToCategory(selectedCategory, product);
    }

    public static void listarProductos() {
        System.out.println("-------------------");
        System.out.println("*** Listar productos ***");
        List<Product> productos = productService.listar();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Product product : productos) {
                System.out.println("Productos registrados:");

                        System.out.println("ID: " + product.getId() + ", Nombre: " + product.getName() + ", Descripción: " + product.getDescription() + ", Precio: " + product.getPrice() + ", Categoría: " + product.getCategory().getName());
            }
        }
    }

    public static void crearCategoria() {
        System.out.println("-------------------");
        System.out.println("*** Creación de categorias ***");
        System.out.print("Nombre de la categoría: ");
        String name = scanner.nextLine();
        System.out.print("Descripción de la categoría: ");
        String desc = scanner.nextLine();
        Integer id = categoryService.listar().size() + 1;
        Category category = new Category(id, name, desc);
        categoryService.crear(category);
        System.out.println("Categoría creada exitosamente.");
    }

    public static void listarCategorias() {
        System.out.println("-------------------");
        System.out.println("*** Listar categorias ***");
        List<Category> categorias = categoryService.listar();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
        } else {
            System.out.println("Categorías registradas:");
            for (Category category : categorias) {
                System.out.println("ID: " + category.getId() + ", Nombre: " + category.getName() + ", Descripción: " + category.getDescription());
            }
        }
    }
}
