package com.etsy.sahale

import org.junit.runner.RunWith

import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FlowStatusSpec extends FlatSpec with ShouldMatchers {

  val initialExpected = Map[String, String](
    "jt_url" -> FlowTracker.UNKNOWN,
    "user_name" -> System.getProperty("user.name"),
    "flow_status" -> "NOT_LAUNCHED",
    "total_stages" -> "0",
    "flow_progress" -> "0.00",
    "flow_duration" -> "0",
    "flow_hdfs_bytes_written" -> "0",
    "yarn_job_history" -> FlowTracker.NOT_YARN_JOB
  )

  "A FlowStatus" should "provide a default initial state before the job launches" in {
    FlowStatus.initial should be (initialExpected)
  }

  "A FlowStatus" should "require a valid Flow instance" in {
    val fs = new FlowStatus(null)
    intercept[NullPointerException] {
      fs.toMap
    }
  }

}

