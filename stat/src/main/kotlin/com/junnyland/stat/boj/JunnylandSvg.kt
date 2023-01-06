package com.junnyland.stat.boj

fun junnylandSvg(): String = """
<svg width="91" height="20" xmlns="http://www.w3.org/2000/svg">
 <g>
  <title>Layer 1</title>
  <mask id="round">
   <rect width="91" height="20" rx="3" fill="#8bb9dd" id="svg_1"/>
  </mask>
  <g stroke-width="0" filter="url(#svg_2_blur)" id="svg_2" mask="url(#round)">
   <rect stroke-dasharray="2,2" id="svg_3" fill="#2bb9f2" height="20" width="48" y="-1" x="0"/>
   <rect stroke-dasharray="2,2" id="svg_4" fill="#2bb9f2" height="20" width="43" x="48" y="-1"/>
   <rect stroke-dasharray="2,2" id="svg_5" fill="#2bb9f2" height="20" width="91" y="-1" x="0"/>
  </g>
  <g id="svg_6" font-size="11" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" text-anchor="middle" fill="#fff">
   <text id="svg_7" fill-opacity="0.3" fill="#010101" y="15" x="46">JUNNYLAND:lib</text>
   <text id="svg_8" y="14" x="46">JUNNYLAND:lib</text>
  </g>
 </g>
 <defs>
  <filter height="200%" width="200%" y="-50%" x="-50%" id="svg_2_blur">
   <feGaussianBlur stdDeviation="5.5" in="SourceGraphic"/>
  </filter>
 </defs>
</svg>
        """.trimIndent()