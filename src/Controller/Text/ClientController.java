package Controller.Text;

import Controller.ControllerTextFile;

/**
 *
 * @author Jair Brannn Junior RA: 2052075
 */
public class ClientController extends ControllerTextFile{
    public ClientController(int typeFile) {
        setFile("Clients", typeFile);
    }
}
