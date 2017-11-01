import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class myCalculator extends Application{
	
	public static void main(String[] args) {
	   launch(args);
	}
	
	public class OperationFactory {
		public Operation getOp(String op) {
			if (op == null)
				return null;
			else if (op.equals("ADD")) {
				return new Add();
			}
			else if (op.equals("SUBTRACT")) {
				return new Subtract();
			}
			else if (op.equals("MULTIPLY")) {
				return new Multiply();
			}
			else if (op.equals("DIVIDE")) {
				return new Divide();
			}
			return null;
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("myCalculator");
		
		final TextField num1 = new TextField();
		final TextField num2 = new TextField();
		Label prompt = new Label("Enter two integers:");
		final Label output = new Label("");
		
		final Button add = new Button("+");
		final Button subtract = new Button("-");
		final Button multiply = new Button("*");
		final Button divide = new Button("/");
		
		output.setAlignment(Pos.CENTER);
		output.setStyle("-fx-border-color: #000; -fx-padding: 8px;");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.add(prompt, 0, 1);
		grid.add(add, 0, 3);
		grid.add(subtract, 1, 3);
		grid.add(multiply, 0, 4);
		grid.add(divide, 1, 4);
		grid.add(num1, 0, 2);
		grid.add(num2, 1, 2);
		grid.add(output, 0, 0, 2, 1);;
		
		num1.setPrefWidth(100);
		num2.setPrefWidth(100);
		add.setPrefWidth(100);
		subtract.setPrefWidth(100);
		multiply.setPrefWidth(100);
		divide.setPrefWidth(100);
		output.setPrefWidth(215);
		
		final OperationFactory opFac = new OperationFactory();
		
		add.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				final int op1, op2;
				op1 = Integer.parseInt(num1.getText());
				op2 = Integer.parseInt(num2.getText());
				Operation operation = opFac.getOp("ADD");
				output.setText("= " + operation.operate(op1, op2));
			}
		});
		
		subtract.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				final int op1, op2;
				op1 = Integer.parseInt(num1.getText());
				op2 = Integer.parseInt(num2.getText());
				Operation operation = opFac.getOp("SUBTRACT");
				output.setText("= " + operation.operate(op1, op2));
			}
		});
		
		multiply.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				final int op1, op2;
				op1 = Integer.parseInt(num1.getText());
				op2 = Integer.parseInt(num2.getText());
				Operation operation = opFac.getOp("MULTIPLY");
				output.setText("= " + operation.operate(op1, op2));
			}
		});
		
		divide.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				final int op1, op2;
				op1 = Integer.parseInt(num1.getText());
				op2 = Integer.parseInt(num2.getText());
				Operation operation = opFac.getOp("DIVIDE");
				output.setText("= " + operation.operate(op1, op2));
			}
		});
		
		Scene scene = new Scene(grid, 350, 350);
		stage.setScene(scene);
		
		stage.show();
	}
	
}
