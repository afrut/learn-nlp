import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.PipelineModel

object Main {
  def main(args: Array[String]){
    // val spark = SparkSession.builder().appName("Test").getOrCreate()

    // val filepath = "..\\data\\mini_newsgroups\\"
    // val texts = spark.sparkContext.wholeTextFiles(filepath).toDF(schema = schema)
    // val schema = StructType([StructField("filename", StringType())
    //   ,StructType("text", StringType())])

    // texts.show()

    val explainDocumentPipeline = PipelineModel.load("..\\johnsnowlabs.nlp\\explain_document_ml_en_3.0.0_3.0_1616473253101\\")
    // spark.stop()
  }
}