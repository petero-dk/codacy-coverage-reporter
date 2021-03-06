package com.codacy.rules.commituuid.providers

import com.codacy.model.configuration.CommitUUID
import com.codacy.rules.commituuid.CommitUUIDProvider

/** Semaphore CI provider */
class SemaphoreCIProvider extends CommitUUIDProvider {
  val name: String = "Semaphore CI"

  override def validate(a: Map[String, String]): Boolean = {
    a.get("CI").contains("true") && a.get("SEMAPHORE").contains("true")
  }

  override def getUUID(a: Map[String, String]): Either[String, CommitUUID] =
    withErrorMessage(a.get("REVISION"))
}
