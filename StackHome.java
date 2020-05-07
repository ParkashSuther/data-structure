package STACK;

import HOME.Home;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StackHome extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Group root = new Group();
		int size=5;
		MyStack stack =new MyStack(size);
		
		TextArea status = new TextArea();
		status.setStyle("-fx-background-color: #808080; -fx-text-fill: green; -fx-text-size:20px;");
		status.setTranslateY(10);
		status.setPrefHeight(200);
		status.setPrefWidth(200);
		status.appendText(">>"+size+" size of Array\n");
		
		
		TextField push = new TextField();
		//push.setPrefHeight(40);
		push.setPrefWidth(140);
		
		
		Button pushbtn = new Button("Push");
		pushbtn.setPrefWidth(50);
	//	pushbtn.setPrefHeight(40);
		pushbtn.setTranslateX(10);
	//	pushbtn.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
		
		pushbtn.setOnAction(e->{
			if(stack.getTop()!=size-1) {
			stack.Push(push.getText());
			box(root,stack.getTop(),1,push.getText());
			status.appendText(">>"+stack.data(stack.getTop())+" added at "+stack.getTop()+"\n");
			}
			else
			{
				status.appendText(">> Stack is Full\n");	
			}
			
			
			
		});
		
		Button pop = new Button("Pop");
		pop.setPrefWidth(200);
	//	pop.setPrefHeight(40);
		pop.setTranslateY(5);
		//pop.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white;");
		
		pop.setOnAction(e->{
			if(stack.getTop()!=size) {
			box(root,stack.getTop(),0,push.getText());
			if(stack.getTop()>-1)
			status.appendText(">>"+stack.Pop()+" removed at ["+stack.getTop()+"]\n");
			else
				status.appendText(">>"+stack.Pop()+" \n");	
			}
			else
				status.appendText(">>Stack is Empty\n");

				
		});
		
		Line line =new Line();
		line.setStartX(230);
		line.setStartY(100);
		line.setEndX(230);
		line.setEndY(500);
    	line.setStroke(Color.RED);
		
		Button back = new Button("Back");
		back.setPrefWidth(200);
	//	back.setPrefHeight(40);
		back.setTranslateY(20);
		back.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		
		back.setOnAction(e->{
			Home gae = new Home();
				try {
				gae.start(stage);
				} catch (Exception e1) {
				}
		});
		
		HBox pushlay= new HBox();
		
		VBox prop = new VBox();
		prop.setLayoutX(10);
		prop.setLayoutY(100);
		
		
		
	//	root.getChildren().add(status);
		prop.getChildren().addAll(pushlay,pop,status,back);
		pushlay.getChildren().addAll(push,pushbtn);
		root.getChildren().addAll(prop);
		root.getChildren().add(line);
		Scene scene = new Scene(root,900,600);
		scene.setFill(Color.AZURE);
		stage.setScene(scene);
		stage.show();
	}
	 public void setText(Group root,String txt,double x ,double y,int t) {
	    	Text text = new Text(txt);
	    	text.setLayoutX(x+10);
	    	text.setLayoutY(y+22);
	    	text.setFont(new Font(20));
	    	if(t==1)
	    	text.setFill(Color.BLUEVIOLET);
	    	else
	    		text.setFill(Color.AZURE);
	    	root.getChildren().add(text);
	    }
	 
		public void box(Group root,int front,int q,String value) {
			double startx=250,starty=100;
			Rectangle shaper=null;
			 int x=front*40;
			if(q==1) {
			//	int x=front*40;
				shaper = new Rectangle(startx,starty+x,100,30);
				shaper.setStyle("-fx-color: #8A2BE2; ");
			shaper.setArcHeight(10);
			shaper.setArcWidth(10);

			shaper.setStroke(Color.BURLYWOOD);
			shaper.setStrokeWidth(2.5);
			shaper.setStrokeType(StrokeType.INSIDE);
			shaper.setFill(Color.DARKGRAY);
				
					
			}
			 if(q==0)
			{
				
			shaper = new Rectangle(startx,starty+x,100,30);
			shaper.setFill(Color.AZURE);
			}
			
			root.getChildren().add(shaper);
			setText(root,value,startx,starty+x,q);
		}
	
public static void main(String[] args) {
	launch(args);
}
}