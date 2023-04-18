param($unit)
$root = Get-Location;

wt -w 0 nt -d "$root./application/web/source/ctrl-intelligence" --title "CLIENT";
wt -w 0 nt -d "$root./application/web/test" --title "CLIENT-TEST";
wt -w 0 nt -d "$root./service/purchase/source" --title "SERVICE";
wt -w 0 nt -d "$root./service/purchase/test" --title "SERVICE-TEST";


if ($unit -eq "true") {
    wt -w 0 nt -d "$root./application/web/source/ctrl-intelligence" --title "CLIENT-UNIT";
}
