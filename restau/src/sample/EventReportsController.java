package sample;
import DB.EventReports;
import DB.DBEvents;
import DB.Delete;
import DB.Update;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
public class EventReportsController implements Initializable {
    private Main main;
    @FXML
    private TableView<EventTable>tableView;

    ObservableList<EventTable> data;
    @FXML
    private Button back;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<EventTable, String> eventIdCol = new TableColumn<>("Event Id");
        eventIdCol.setMinWidth(120);
        eventIdCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("event_id"));

        TableColumn<EventTable, String> eventNameCol = new TableColumn<>("Event Name");
        eventNameCol.setMinWidth(150);
        eventNameCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("event_name"));

        TableColumn<EventTable, String> discountCol = new TableColumn<>("Discount");
        discountCol.setMinWidth(120);
        discountCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("discount"));

        TableColumn<EventTable, String> eventTypeCol = new TableColumn<>("Event Type");
        eventTypeCol.setMinWidth(150);
        eventTypeCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("event_type"));
        
        TableColumn<EventTable, String> totalgotCol = new TableColumn<>("Total_Earning");
        totalgotCol.setMinWidth(150);
        totalgotCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("total_got"));
        tableView.getColumns().addAll(eventIdCol, eventNameCol,discountCol, eventTypeCol,totalgotCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new EventReports().getAllEvents();
        for (List<String> row : userDataList)
        {
            EventTable u = new EventTable(row.get(0), row.get(1), null,null,null, row.get(2), row.get(3));
            u.setTotal_got(row.get(4));
            data.add(u);
        }
        tableView.setEditable(true);
        tableView.setItems(data);
    }

    @FXML
    void backAction(ActionEvent event)
    {
        try
        {
            main.showReports();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    
    public void setMain(Main main)
    {
        this.main = main;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
