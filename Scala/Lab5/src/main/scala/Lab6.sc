
  def pascal(c: Int, r: Int): Int = {
    if c>r then 0
    else if c==r then 1
    else pascal(c-1,r) + pascal(c-1,r-1)
  }
  pascal(1,1)

