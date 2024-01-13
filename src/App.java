public class App {

    public static void main(String[] args) {

        int width = 20;
        int height = 20;
        int positionX = 0;
        int positionY = 0;
        boolean moveRight = true;

        while (true) {
            System.out.print("\033[H\033[2J");

            drawBall(positionX, positionY, width, height);

            boolean regresar = true;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (moveRight) {
                positionX++;
            } else {
                positionX--;
            }

            positionY++;

            if (positionX == 0 || positionX == width - 1) {
                moveRight = !moveRight;
            }

            if (positionY == height) {
                regresar = false;
            }
        }
    }

    private static void drawBall(int positionX, int positionY, int width, int height) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == positionY && j == positionX) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
