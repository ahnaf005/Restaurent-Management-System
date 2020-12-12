package sample;

import DB.DBEvents;
import DB.Delete;
import DB.Update;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.TextFieldTableCell;

public class EventTableController {

    private Main main;
    @FXML
    private TableView<EventTable>tableView;

    ObservableList<EventTable> data;
    @FXML
    private Button delete;
    @FXML
    private Button button;
    @FXML
    private Button insert;
    private boolean init = true;

    private void initializeColumns()
    {
        TableColumn<EventTable, String> eventIdCol = new TableColumn<>("Event Id");
        eventIdCol.setMinWidth(120);
        eventIdCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("event_id"));

        TableColumn<EventTable, String> eventNameCol = new TableColumn<>("Event Name");
        eventNameCol.setMinWidth(150);
        eventNameCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("event_name"));

        TableColumn<EventTable, String> venueCol = new TableColumn<>("Venue");
        venueCol.setMinWidth(100);
        venueCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("venue"));

        TableColumn<EventTable, String> startDateCol = new TableColumn<>("start date");
        startDateCol.setMinWidth(130);
        startDateCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("start_date"));

        TableColumn<EventTable, String> endDateCol = new TableColumn<>("end date");
        endDateCol.setMinWidth(130);
        endDateCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("end_date"));

        TableColumn<EventTable, String> discountCol = new TableColumn<>("Discount");
        discountCol.setMinWidth(120);
        discountCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("discount"));

        TableColumn<EventTable, String> eventTypeCol = new TableColumn<>("Event Type");
        eventTypeCol.setMinWidth(150);
        eventTypeCol.setCellValueFactory(new PropertyValueFactory<EventTable,String>("event_type"));
        
        eventNameCol.setCellFactory(TextFieldTableCell.<EventTable>forTableColumn());
        eventNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EventTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EventTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEvent_name(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_name());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_name());
                boolean update = new Update().updateEventClmn(fID,"event_name",value);
                AlertDialogShow(update);
            }
        });
        venueCol.setCellFactory(TextFieldTableCell.<EventTable>forTableColumn());
        venueCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EventTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EventTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setVenue(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getVenue());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getVenue());
                boolean update = new Update().updateEventClmn(fID,"venue",value);
                AlertDialogShow(update);
            }
        });
        startDateCol.setCellFactory(TextFieldTableCell.<EventTable>forTableColumn());
        startDateCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EventTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EventTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setStart_date(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getStart_date());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getStart_date());
                boolean update = new Update().updateEventClmn(fID,"start_date",value);
                AlertDialogShow(update);
            }
        });
        
        endDateCol.setCellFactory(TextFieldTableCell.<EventTable>forTableColumn());
        endDateCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EventTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EventTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEnd_date(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEnd_date());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEnd_date());
                boolean update = new Update().updateEventClmn(fID,"end_date",value);
                AlertDialogShow(update);
            }
        });
        
        discountCol.setCellFactory(TextFieldTableCell.<EventTable>forTableColumn());
        discountCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EventTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EventTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setDiscount(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getDiscount());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getDiscount());
                boolean update = new Update().updateEventClmn(fID,"discount",value);
                AlertDialogShow(update);
            }
        });
        
        eventTypeCol.setCellFactory(TextFieldTableCell.<EventTable>forTableColumn());
        eventTypeCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EventTable, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<EventTable, String> t) {
                t.getTableView().getItems().get(t.getTablePosition().getRow()).setEvent_type(t.getNewValue());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_type());
                String fID = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                System.out.println(t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_id());
                String value = (t.getTableView().getItems().get(t.getTablePosition().getRow()).getEvent_type());
                boolean update = new Update().updateEventClmn(fID,"event_type",value);
                AlertDialogShow(update);
            }
        });
        tableView.getColumns().addAll(eventIdCol, eventNameCol, venueCol, startDateCol, endDateCol, discountCol, eventTypeCol);
    }

    public void load()
    {
        if (init)
        {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList();

        List<List<String>> userDataList = new DBEvents().getAllEvents();
        for (List<String> row : userDataList)
        {
            EventTable u = new EventTable(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6));
            data.add(u);
        }
        tableView.setEditable(true);
        tableView.setItems(data);
    }

    @FXML
    void logoutFunc(ActionEvent event)
    {
        try
        {
            main.showLoginPage();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void showHome(ActionEvent event)
    {
        try
        {
            if(Constants.userType.equals("manager"))
                main.showManagerWindow();
            else
                main.showAdminWindow();
                //main.showAdminWindow(main.adminType);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    void InsertEvents(ActionEvent event)
    {
        try
        {
            //make customer insert or update window..
            main.InsertEvent();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void AlertDialogShow(boolean success)
    {
        if(success)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update Successful");
            alert.setHeaderText("Update Notice.");
            alert.setContentText("Event Details have been successfully updated");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Notice");
            alert.setHeaderText("Failed To Update");
            alert.setContentText("Event Details update Failed");
            alert.showAndWait();
        }
    }
    @FXML
    void deleteAction(ActionEvent event)
    {
        boolean update=false;
        if(tableView.getSelectionModel().getSelectedItems()!=null){
            update = new Delete().DeleteEvents(tableView.getSelectionModel().getSelectedItem().getEvent_id());
            AlertDialogShow(update);
            if(update)
                tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        }
    }
    
    
    public void setMain(Main main)
    {
        this.main = main;
    }
}
