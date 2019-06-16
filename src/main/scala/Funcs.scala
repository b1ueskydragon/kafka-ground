import java.io.Closeable

import scala.annotation.tailrec

object Funcs {
  @tailrec
  def retry(isInfiniteLoop: Boolean = true)(f: => Unit): Unit =
    if (!isInfiniteLoop) f
    else {
      f
      retry(isInfiniteLoop)(f)
    }

  def using(c: Closeable)(f: Closeable => Unit) {
    try f(c)
    finally c.close()
  }

  def using(c1: Closeable, c2: Closeable)(f: (Closeable, Closeable) => Unit) {
    try f(c1, c2)
    finally {
      c1.close()
      c2.close()
    }
  }

}
