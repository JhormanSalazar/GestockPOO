package Modelos;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                    crearInventario();
                    break;
                case 4:
                    listarInventarios();
                    break;
                case 5:
                    crearProducto();
                    break;
                case 6:
                    listarProductos();
                    break;
                case 7:
                    crearCategoria();
                    break;
                case 8:
                    listarCategorias();
                    break;
                case 9:
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
        System.out.println("3. Crear inventario");
        System.out.println("4. Listar inventarios");
        System.out.println("5. Crear producto");
        System.out.println("6. Listar productos");
        System.out.println("7. Crear categoría");
        System.out.println("8. Listar categorías");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void crearUsuario() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        User user = new User(User.listarUsuarios().size() + 1, name, email, password);  // Asignamos ID secuencial
        User.crearUsuario(user);
        System.out.println("Usuario creado exitosamente.");
    }

    public static void listarUsuarios() {
        List<User> usuarios = User.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (User user : usuarios) {
                System.out.println("ID: " + user.getUserId() + ", Nombre: " + user.getName() + ", Email: " + user.getEmail());
            }
        }
    }

    public static void crearInventario() {
        System.out.print("Nombre del inventario: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Imagen del inventario: ");
        String image = scanner.nextLine();

        // Asumimos que el primer usuario (puedes cambiar esta lógica según tus necesidades)
        User user = User.listarUsuarios().isEmpty() ? null : User.listarUsuarios().get(0);

        Inventory inventory = new Inventory(Inventory.listarInventarios().size() + 1, name, description, image, true, user);
        Inventory.crearInventario(inventory);
        System.out.println("Inventario creado exitosamente.");
    }

    public static void listarInventarios() {
        List<Inventory> inventarios = Inventory.listarInventarios();
        if (inventarios.isEmpty()) {
            System.out.println("No hay inventarios registrados.");
        } else {
            System.out.println("Inventarios registrados:");
            for (Inventory inventory : inventarios) {
                System.out.println("ID: " + inventory.getInventoryId() + ", Nombre: " + inventory.getName() + ", Usuario: " + (inventory.getUser() != null ? inventory.getUser().getName() : "Ninguno"));
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
        Integer price = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        System.out.print("Categoría (nombre): ");
        String categoryName = scanner.nextLine();
        Category category = new Category(Category.listarCategorias().size() + 1, categoryName, "Descripción de la categoría", true);
        Category.crearCategoria(category);

        Product product = new Product(Product.listarProductos().size() + 1, name, description, image, price, category);
        Product.crearProducto(product);
        System.out.println("Producto creado exitosamente.");
    }

    public static void listarProductos() {
        List<Product> productos = Product.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Productos registrados:");
            for (Product product : productos) {
                System.out.println("ID: " + product.getProductId() + ", Nombre: " + product.getName() + ", Precio: " + product.getPrice() + ", Categoría: " + product.getCategory().getName());
            }
        }
    }

    public static void crearCategoria() {
        System.out.print("Nombre de la categoría: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();

        Category category = new Category(Category.listarCategorias().size() + 1, name, description, true);
        Category.crearCategoria(category);
        System.out.println("Categoría creada exitosamente.");
    }

    public static void listarCategorias() {
        List<Category> categorias = Category.listarCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
        } else {
            System.out.println("Categorías registradas:");
            for (Category category : categorias) {
                System.out.println("ID: " + category.getCategoryId() + ", Nombre: " + category.getName() + ", Descripción: " + category.getDescription());
            }
        }
    }
}
