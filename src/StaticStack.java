import java.util.Scanner;

public class StaticStack<T> {
    private int top = -1;
    private T[] data;

    @SuppressWarnings("unchecked")
    public StaticStack(int size) {
        data = (T[]) new Object[size];
    }

    public void push(T item) {
        if (isFull()) {
            System.out.println("Stack está cheia. Não é possivel adicionar mais itens.");
            return;
        }
        data[++top] = item;
        System.out.println("Item " + item + " adicionado a Stack.");
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack está vazia");
        }
        return data[top--];
    }

    public void clear() {
        top = -1;
        System.out.println("Stack limpada com sucesso.");
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("Stack está vazia.");
        } else {
            System.out.println("Stack atual:");
            for (int i = 0; i <= top; i++) {
                System.out.println(data[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o tamanho da Stack: ");
        int size = scanner.nextInt();

        StaticStack<Integer> stack = new StaticStack<>(size);

        while (true) {
            System.out.println("\nEscolha uma operação: ");
            System.out.println("1. Insira um item");
            System.out.println("2. Remova um item");
            System.out.println("3. Limpe a stack");
            System.out.println("4. Mostrar a stack");
            System.out.println("5. Sair");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Escreva o item para inserir: ");
                    int item = scanner.nextInt();
                    stack.push(item);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println("Item removido: " + stack.pop());
                    } else {
                        System.out.println("Stack está vazia.");
                    }
                    break;
                case 3:
                    stack.clear();
                    break;
                case 4:
                    stack.showStack();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }
}
