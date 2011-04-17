package com.saladwithsteve.mobilemeat

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.net.Uri
import android.widget.{ArrayAdapter, ListView, Toast}
import android.view.View


class MeatList extends ListActivity {
  def flickr(subpath: String) = "http://www.flickr.com/photos/" + subpath

  val meats = Map("Brisket"         -> flickr("azarius/3399436470/sizes/l/"),
                  "Sausage"         -> flickr("wrigleywrld/3850003593/sizes/l/"),
                  "Ribs"            -> flickr("wrigleywrld/3828383890/sizes/l/in/set-72157622165170836/"),
                  "Tasmanian Steak" -> flickr("brucewood/535612522/sizes/m/"),
                  "Red Duck"        -> flickr("75304241@N00/343301651/sizes/l/"),
                  "Assorted Meats"  -> flickr("foodnut/3885598840/sizes/o/"),
                  "Deli Meats"      -> flickr("sifu_renka/2096895740/sizes/l/"),
                  "Ground Beef"     -> flickr("aventurista/15704030/sizes/o/"),
                  "Beef Jerkey"     -> flickr("andreelau/2149549554/sizes/o/"),
                  "A fine meat"     -> flickr("stefz/20480619/sizes/o/"),
                  "Meat face"       -> flickr("epiglotic/2126582943/sizes/l/"))

  val MEATS: Array[String] = meats.keys.toArray

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

    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(meats(meat))))
  }
}


