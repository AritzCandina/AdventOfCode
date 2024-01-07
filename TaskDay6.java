public class TaskDay6 {

        public static void main(String[] args) {
            day6();
        }

        public static void day6() {


            long puzzleInputAritz = 0L;
            puzzleInputAritz = numbersToBeatRecord(55, 246);
            puzzleInputAritz *= numbersToBeatRecord(82, 1441);
            puzzleInputAritz *= numbersToBeatRecord(64, 1012);
            puzzleInputAritz *= numbersToBeatRecord(90, 1111);
            System.out.println("Total number of times to beat the record with Puzzle from Aritz : " + puzzleInputAritz);

            long puzzleInputLukas = 0L;
            puzzleInputLukas = numbersToBeatRecord(53, 250);
            puzzleInputLukas *= numbersToBeatRecord(91, 1330);
            puzzleInputLukas *= numbersToBeatRecord(67, 1081);
            puzzleInputLukas *= numbersToBeatRecord(68, 1025);
            System.out.println("Total number of times to beat the record with Puzzle from Lukas: " + puzzleInputLukas);
        }

        public static long numbersToBeatRecord(long time, long record) {
            long number = 0L;

            for (long i = 0; i < time; i++) {
                long timeLeft = time - i;
                if (i * timeLeft > record) {
                    number++;
                }
            }
            return number;
        }

}
