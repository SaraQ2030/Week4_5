package org.example.tracker.Controller;


import org.example.tracker.Api.ApiMessage;
import org.example.tracker.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/tracker")
public class TrackerController {
    ArrayList<Tracker> trackers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }

    @PostMapping("/add")
    public ApiMessage createTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
        return new ApiMessage("Tracker Created successfully ");
    }

    @PutMapping("/update/{index}")
    public ApiMessage updateTracker(@PathVariable int index, @RequestBody Tracker tracker) {
        trackers.set(index, tracker);
        return new ApiMessage("updated successfully ");
    }

    @DeleteMapping("/delete/{index}")
    public ApiMessage deleteTracker(@PathVariable int index) {
        trackers.remove(index);
        return new ApiMessage("Deleted successfully");
    }

@GetMapping("/search")
    public ApiMessage searchTrack(@RequestBody Tracker tit) {
    for (Tracker t : trackers) {
        if (t.getTitle().equalsIgnoreCase(tit.getTitle()))
            return new ApiMessage("is found  " + t);

    }
        return new ApiMessage("Not found ");

}

@PutMapping("/change")
public ApiMessage changeStatus(@RequestBody Tracker status) {
    for (Tracker tra : trackers) {
        if (tra.getStatus().equalsIgnoreCase(status.getStatus())) {
            return new ApiMessage("the Status Already done");
        } else {
            tra.setStatus("done");
        }
    }
    return new ApiMessage("End change");
}

}
