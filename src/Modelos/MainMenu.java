package Modelos;

import Modelos.Categories.Category;
import Modelos.Products.Product;
import Modelos.Users.User;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final User user = new User();
    private static final Product product = new Product();
    private static final Category category = new Category();
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
        } while (opcion != 9);
    }

    public static void mostrarMenu() {
        System.out.println("Menú Principal:");
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
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        // Obtenemos un nuevo ID secuencial
        int ID = user.listar().size() + 1;

        User user = new User(ID, name, email, password);

        user.crear(user);
        System.out.println("Usuario creado exitosamente.");
    }

    public static void listarUsuarios() {
        List<User> usuarios = user.listar();
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
        System.out.print("Nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Imagen del producto: ");
        String image = scanner.nextLine();
        System.out.print("Precio: ");
        Double price = scanner.nextDouble();
        System.out.println("Cuanta cantidad del producto tiene actualmente");
        // TODO almacenar el producto en una categoria
        scanner.nextLine();

        //TODO
        System.out.print("Categoría (nombre): ");
        String categoryName = scanner.nextLine();

        Integer id = category.listar().size() + 1;

        Category category = new Category(id, categoryName, "Descripción de la categoría");
        category.crear(category);
        //

        List<Product> products = product.listar();
        int nuevoId = products.size() + 1;

        Product product = new Product(nuevoId, name, description, image, price, stock, category);
        productServices.crear(product);
        System.out.println("Producto creado exitosamente.");
    }

    public static void listarProductos() {
        List<Product> productos = productServices.listar();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Productos registrados:");
            for (Product product : productos) {
                System.out.println("ID: " + product.getProductId() + ", Nombre: " + product.getName() + ", Descripción: " + product.getDescription() + ", Precio: " + product.getPrice() + ", Categoría: " + product.getCategory().getName());
            }
        }
    }

    public static void crearCategoria() {
        System.out.print("Nombre de la categoría: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();

        Integer id = category.listar().size() + 1;

        Category category = new Category(id, name, description);
        Category.crearCategoria(category);
        System.out.println("Categoría creada exitosamente.");
    }

    public static void listarCategorias() {
        List<Category> categorias = category.listar();
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
