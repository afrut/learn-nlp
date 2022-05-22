// :load "spark-shell\\test.scala"

import org.apache.spark.sql.types.{StructType, StructField, StringType, ArrayType}
import org.apache.spark.sql.functions.{col, split, explode, size}

// Create DataFrame of text files
val filepath = "..\\data\\mini_newsgroups\\*"
val texts_df = spark.sparkContext.wholeTextFiles(filepath).toDF("filename", "text")
texts_df.show()

Create newsgroup column
val foo = texts_df.withColumn("newsgroup", split($"filename", "/").getItem(6))

import org.apache.spark.ml.PipelineModel
val explainDocumentPipeline =
PipelineModel.load("..\\johnsnowlabs.nlp\\explain_document_ml_en_3.0.0_3.0_1616473253101\\")


val data = Seq("We are very happy about SparkNLP").map(x => Tuple1(x))
val df = spark.createDataFrame(data).toDF("text")
val annotations = explainDocumentPipeline.transform(df)

val sch = annotations.schema
val cols = sch.map(structfield => structfield.dataType match {
  case dt: ArrayType => f"${structfield.name}.result"
  case _ => f"${structfield.name}"
})

val foo = annotations.select(cols.map(col):_*).
  toDF(annotations.columns:_*).
  collect()(0)

val res = scala.collection.mutable.Map[String, List[String]]()



for (cnt <- 0 to sch.length - 1) {
  sch(cnt).dataType match {
    case dt: ArrayType => {res(sch(cnt).name) = foo.getSeq[String](cnt).toList}
    case _ => {}
  }
}