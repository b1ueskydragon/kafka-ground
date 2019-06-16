import scala.annotation.tailrec

object Funcs {
  @tailrec
  def retry(isInfiniteLoop: Boolean = true)(f: => Unit): Unit =
    if (!isInfiniteLoop) f
    else {
      f
      retry(isInfiniteLoop)(f)
    }
}
