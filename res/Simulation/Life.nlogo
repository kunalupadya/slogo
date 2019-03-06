things that must be done
1. make patches
2.





patches-own [
  living?         ;; indicates if the cell is living
  live-neighbors  ;; counts how many neighboring cells are alive
]


to setup-blank
  ask patches
    [ cell-death ]
end

to setup-random
  ask patches
    [ ifelse random-float 100.0 < initial-density
        [ cell-birth ]
        [ cell-death ] ]
end

to cell-birth
  set living? true
  set pcolor fgcolor
end

to cell-death
  set living? false
  set pcolor bgcolor
end

to go
  ask patches
    [ set live-neighbors count neighbors with [living?] ]
                                                                        ;; Starting a new "ask patches" here ensures that all the patches
                                                                        ;; finish executing the first ask before any of them start executing
                                                                      ;; the second ask.  This keeps all the patches in sync with each other,
                                                                        ;; so the births and deaths at each generation all happen in lockstep.
  ask patches
    [ ifelse
        equal? alive-neighbors 3
            [ cell-birth ]
            [ if notequal? alive-neighbors 2
                [ cell-death ] ]
                ]
end



