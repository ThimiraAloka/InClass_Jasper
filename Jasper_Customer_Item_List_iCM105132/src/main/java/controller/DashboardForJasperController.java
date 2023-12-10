package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;

public class DashboardForJasperController {

    @FXML
    void customerButtonOnAction(ActionEvent event) throws JRException {
        JasperDesign design = JRXmlLoader.load("src/main/resources/report/Customer_List_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JasperViewer.viewReport(jasperPrint,false);

    }

    @FXML
    void itemButtonOnAction(ActionEvent event) throws JRException {
        JasperDesign design = JRXmlLoader.load("src/main/resources/report/Item_List_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(design);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JasperViewer.viewReport(jasperPrint,false);
    }

}
