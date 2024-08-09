# Chicago "L" Challenge Route Calculator
This is a WIP for the team going for the world record later this year. Used to corroborate human mapping.

## The Chicago "L" Challenge
The Chicago "L" Challenge is a challenge in which one must, in the fastest time window possible, be on a train with the doors open at all stations on the Chicago "L" System. The only methods of transit allowed are trains, busses, and walking.

## Pre-Git Version History
v1
Linden->Howard->Skokie->Howard->Roosevelt->Halsted->Ashland->63rd->95th->63rd->Roosevelt->King Drive->Cottage Grove->Harlem->Clinton->54th->Midway->Roosevelt->Midway->Loop->Clinton->Loop->Kimball->Jefferson Park->Ohare->Forest Park

v1.1 (modified Roosevelt and loop connections)
Linden->Howard->Skokie->Howard->Roosevelt->Halsted->Ashland->Cottage Grove->King Drive->Roosevelt->Loop->Clinton->54th->Clinton->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Midway->Roosevelt->63rd->95th

v1.2 (added Garfield to optimize green line)
Linden->Howard->Skokie->Howard->Roosevelt->Loop->Clinton->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Clinton->54th->Midway->Ashland->Halsted->King Drive->Cottage Grove->Midway->Roosevelt->63rd->95th

v1.3 (modified Roosevelt connections)
Linden->Howard->Skokie->Howard->Roosevelt->Cottage Grove->King Drive->Halsted->Ashland->Midway->Roosevelt->Loop->Clinton->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Clinton->54th->Midway->Cottage Grove->Roosevelt->63rd->95th

v1.4 (testing 2 falses)
Outputted same as v1.3

v1.5 (removed immediate double back rule, falses should fix it, back on 1 false)
Outputted same route as v1.3

v1.6 (changed the going back on true to an if instead of an else if, will slow down but improve)
Outputted same route as v1.3

v1.7 (modified Roosevelt connections)
N/A

v1.8 (modified timetable inaccuracies)
Linden->Howard->Skokie->Howard->Roosevelt->Midway->Ashland->Halsted->Cottage Grove->King Drive->63rd->95th->63rd->Roosevelt->Loop->Clinton->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Clinton->54th

v1.9 (removed king drive and halsted, fixed map inaccuracies)
Linden->Howard->Skokie->Howard->Roosevelt->Loop->Clinton->54th->Clinton->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Roosevelt->Midway->Ashland->Garfield->Cottage Grove->Garfield->Roosevelt->63rd->95th

v1.10 (map tuning, fixed bus inaccuracies)
Failed

v1.10.1 (testing 2 falses)
Failed

v1.11 (merged Ashland and cottage grove into GLSS)
Linden->Howard->Skokie->Howard->Roosevelt->Loop->Clinton->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Roosevelt->Garfield->GLSS->63rd->95th->63rd->Roosevelt->Midway->Loop->Clinton->54t

v1.12 (map adjustment for green and pink lines)
Incomplete

v1.13 (removed red line Roosevelt connection from Howard)
Failed

v1.14 (readded connection, finishing 1.12)
Failed

v2.0 (large map rework, removed unnecessary stations)
Linden->Howard->Skokie->Howard->Loop->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Midway->54th->Loop->Garfield->GLSS->63rd->95th->63rd->Loop

v2.1 (testing checking all locations as starting point)
Same as v2.0

v2.2 (testing 2 falses, optimization)
Linden->Howard->Skokie->Howard->Loop->63rd->95th->63rd->Loop->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Midway->54th->Loop->Garfield->GLSS

v2.3 (adjusting GLSS timing to prevent coming onto it from the red line from being discouraged)
Linden->Howard->Skokie->Howard->Loop->63rd->95th->63rd->GLSS->Garfield->Loop->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Midway->54th->Loop

v2.4 (readded Roosevelt to correct for loop timing)
No meaningful change

v2.5 (removed Roosevelt)
Linden->Howard->Skokie->Howard->Loop->63rd->95th->63rd->GLSS->Garfield->Loop->Harlem->Forest Park->Ohare->Jefferson Park->Kimball->Loop->Midway->54th->Loop