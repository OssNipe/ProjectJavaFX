module TableViewSQL2023 {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires fontawesomefx;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
}
