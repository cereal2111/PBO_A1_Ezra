import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ukuran area: ");
        int size = scanner.nextInt();
        int[][] area = new int[size][size];

        System.out.print("Masukkan titik start X: ");
        int startX = scanner.nextInt();
        System.out.print("Masukkan titik start Y: ");
        int startY = scanner.nextInt();
        System.out.print("Masukkan titik finish X: ");
        int finishX = scanner.nextInt();
        System.out.print("Masukkan titik finish Y: ");
        int finishY = scanner.nextInt();

        System.out.println("Start = " + startX + "," + startY);
        System.out.println("Finish = " + finishX + "," + finishY);

        List<String> path = findPathBFS(area, startX, startY, finishX, finishY);
        printAreaWithPath(area, startX, startY, finishX, finishY, path);
    }

    public static List<String> findPathBFS(int[][] area, int startX, int startY, int finishX, int finishY) {
        List<String> path = new ArrayList<>();
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        boolean[][] visited = new boolean[area.length][area[0].length];

        queueX.offer(startX);
        queueY.offer(startY);

        while (!queueX.isEmpty() && !queueY.isEmpty()) {
            int x = queueX.poll();
            int y = queueY.poll();

            if (x == finishX && y == finishY) {
                path.add("(" + x + "," + y + ")");
                break;
            }

            if (isValidMove(area, x, y) && !visited[x][y]) {
                visited[x][y] = true;
                path.add("(" + x + "," + y + ")");

                if (isValidMove(area, x + 1, y)) {
                    queueX.offer(x + 1);
                    queueY.offer(y);
                }
                if (isValidMove(area, x, y + 1)) {
                    queueX.offer(x);
                    queueY.offer(y + 1);
                }
                if (isValidMove(area, x - 1, y)) {
                    queueX.offer(x - 1);
                    queueY.offer(y);
                }
                if (isValidMove(area, x, y - 1)) {
                    queueX.offer(x);
                    queueY.offer(y - 1);
                }
            }
        }

        return path;
    }

    public static boolean isValidMove(int[][] area, int x, int y) {
        return x >= 0 && x < area.length && y >= 0 && y < area[0].length && area[x][y] != 1;
    }

    public static void printAreaWithPath(int[][] area, int startX, int startY, int finishX, int finishY, List<String> path) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                if (i == startX && j == startY) {
                    System.out.print("S ");
                } else if (i == finishX && j == finishY) {
                    System.out.print("F ");
                } else if (path.contains("(" + i + "," + j + ")")) {
                    System.out.print("| ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}