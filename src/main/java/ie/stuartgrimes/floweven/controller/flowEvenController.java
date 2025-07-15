package ie.stuartgrimes.floweven.controller;

import ie.stuartgrimes.floweven.model.DropDown;
import ie.stuartgrimes.floweven.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.util.HashMap;

@Controller
public class flowEvenController {

  @RequestMapping(method = RequestMethod.GET)
  public String homePage(Model model) {
    DropDown dropDown = new DropDown();
    dropDown.addItem("Camping Next To Water");
    dropDown.addItem("A Forrest");
    dropDown.addItem("As Christy Roved Out");
    model.addAttribute("dropDown", dropDown);

    return "index";
  }

  @PostMapping("/")
  public void submit(Song song, Model model) {
    HashMap<String, String> songMap = new HashMap<>();
    songMap.put("Camping Next To Water", "/Users/stuart/Music/Music/Media.localized/Music/Badly Drawn Boy/The Hour Of The Bewilderbeast/05 Camping Next To Water.mp3");
    songMap.put("A Forest", "/Users/stuart/Music/Music/Media.localized/Music/The Cure/Mixed Up/06 A Forest (Tree Mix).mp3");
    songMap.put("As Christy Roved Out", "/Users/stuart/Music/Music/Media.localized/Music/Planxty/Live 2004/09 As Christy Roved Out.mp3");
    try {
      FileInputStream file = new FileInputStream(songMap.get(song.getName()));
      Player playMP3 = new Player(file);
      playMP3.play();
    } catch (Exception e) {
    }
  }


}
