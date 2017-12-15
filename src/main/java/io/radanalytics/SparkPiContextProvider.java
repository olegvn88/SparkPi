package io.radanalytics;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkException;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

public class SparkPiContextProvider {

    private static SparkPiContextProvider INSTANCE = null;

    private SparkConf sparkConf;
    private JavaSparkContext sparkContext;

    private SparkPiContextProvider() {
    }

    private SparkPiContextProvider(SparkPiProperties props) {
        this.sparkConf = new SparkConf().setAppName("JavaSparkPi");
        this.sparkConf.setJars(new String[]{props.getJarFile()});
        this.sparkContext = new JavaSparkContext(sparkConf);
    }

    public static boolean init(SparkPiProperties props) {
        try {
            if (INSTANCE == null) {
                INSTANCE = new SparkPiContextProvider(props);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static JavaSparkContext getContext() {
        return INSTANCE.sparkContext;
    }

}
