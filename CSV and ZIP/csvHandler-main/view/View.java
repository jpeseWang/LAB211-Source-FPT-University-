package view;

import controller.ContactController;

public class View extends Menu {
    private ContactController controller;

    public View(ContactController controller) {
        super("======= Format CSV Program =======", new String[]{"Import CSV", "Format Address", "Format Name", "Export CSV", "Exit"});
        this.controller = controller;
    }

    @Override
    public void execute() {
        switch (getSelected()) {
            case 1:
                System.out.print("Enter Path: ");
                String path = scanner.nextLine();
                controller.importCSV(path);
                break;
            case 2:
                controller.formatAddress();
                break;
            case 3:
                controller.formatName();
                break;
            case 4:
                System.out.print("Enter Path: ");
                String exportPath = scanner.nextLine();
                controller.exportCSV(exportPath);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
