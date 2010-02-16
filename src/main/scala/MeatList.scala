package com.saladwithsteve.mobilemeat

import _root_.android.app.ListActivity
import _root_.android.content.Intent
import _root_.android.os.Bundle
import _root_.android.net.Uri
import _root_.android.widget.{ArrayAdapter, ListView, Toast}
import _root_.android.view.View


class MeatList extends ListActivity {
  val brisket = ("Brisket" -> "http://www.flickr.com/photos/azarius/3399436470/sizes/l/")
  val sausage = ("Sausage" -> "http://www.flickr.com/photos/wrigleywrld/3850003593/sizes/l/")
  val ribs = ("Ribs" -> "http://www.flickr.com/photos/wrigleywrld/3828383890/sizes/l/in/set-72157622165170836/")
  val redMeat = ("Tasmanian Steak" -> "http://www.flickr.com/photos/brucewood/535612522/sizes/m/")
  val duck = ("Red Duck" -> "http://www.flickr.com/photos/75304241@N00/343301651/sizes/l/")
  val assorted = ("Assorted Meats" -> "http://www.flickr.com/photos/foodnut/3885598840/sizes/o/")
  val deliMeats = ("Deli Meats" -> "http://www.flickr.com/photos/sifu_renka/2096895740/sizes/l/")
  val groundBeef = ("Ground Beef" -> "http://www.flickr.com/photos/aventurista/15704030/sizes/o/")
  val beefJerkey = ("Beef Jerkey" -> "http://www.flickr.com/photos/andreelau/2149549554/sizes/o/")
  val fineMeat = ("A fine meat" -> "http://www.flickr.com/photos/stefz/20480619/sizes/o/")
  val meatFace = ("Meat face" -> "http://www.flickr.com/photos/epiglotic/2126582943/sizes/l/")

  val meatMap = Map.empty ++ List(brisket, sausage, ribs, redMeat, duck, assorted, deliMeats, groundBeef, beefJerkey, fineMeat, meatFace)

  val MEATS: Array[String] = meatMap.keys.toList.toArray

  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    val meatAdapter = new ArrayAdapter[String](this, R.layout.meat, MEATS)
    this.setListAdapter(meatAdapter)
    this.getListView().setTextFilterEnabled(true)
  }

  override def onListItemClick(listView: ListView, view: View, pos: Int, id: Long) {
    val meat = MEATS(pos)

    // Show a hover notification to make the user feel better about the impending meat.
    Toast.makeText(this, "Now Viewing: " + meat, Toast.LENGTH_LONG).show()

    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(meatMap(meat))))
  }
}


