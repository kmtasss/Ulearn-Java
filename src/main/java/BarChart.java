import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Map;

public class BarChart extends JFrame {
    public BarChart(Map<String, Integer> amounts) {
        start(amounts);
    }

    private void start(Map<String, Integer> amounts) {
        CategoryDataset dataset = createDataset(amounts);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset(Map<String, Integer> amounts) {
        var dataset = new DefaultCategoryDataset();
        amounts.forEach((k, v) -> dataset.setValue(v, "section", k));
        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Количество участников в каждом виде спорта за 2008 год",
                "Вид спорта",
                "Количество людей",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
    }
}