package rocket.app.view;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML TextField txtDownpayment;
	
	@FXML Label Various;
	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;
	@FXML TextField txtHouseCost;
	@FXML ComboBox<Integer> cmbTerm;
	@FXML Label lblMortgagePayment;

	
	private TextField txtNew;
	
	private MainApp mainApp;
	
	ObservableList<Integer> years = FXCollections.observableArrayList(15, 30);
	
	@FXML
	private void initialize()
	{
		cmbTerm.setItems(years);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double payment = 0;
		double maxmonthlypayment = lRequest.getdPayment();
		double pt1 = (lRequest.getdIncome() * .28);
		double pt2 = (lRequest.getdIncome() * .36) - lRequest.getdExpenses();
		
		if(pt1 <= pt2) {
			payment = pt1;
		} else {
			payment = pt2;
		}
		
		if(maxmonthlypayment >= payment){
			txtMortgageAmt.setText("Congratulations you can buy ");
		}
		else{
			txtMortgageAmt.setText("This house is out of your price range");
		}
	}
}
