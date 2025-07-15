package ie.stuartgrimes.floweven.model;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

  private List<String > items;

  public DropDown() {
    items = new ArrayList<>();
  }

  public List<String> getItems() {
    return items;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public void addItem(String item) {
    items.add(item);
  }
}
