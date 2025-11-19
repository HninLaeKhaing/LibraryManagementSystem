public class AutoSaveTask implements Runnable {

    private LibraryService library;

    public AutoSaveTask(LibraryService library) {
        this.library = library;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                library.autoSave();
                System.out.println("[AutoSave Completed ✔]");
            } catch (InterruptedException e) {
                System.out.println("AutoSave stopped!");
            }
        }
    }
}
