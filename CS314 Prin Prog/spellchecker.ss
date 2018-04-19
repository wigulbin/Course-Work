
; *********************************************
; *  314 Principles of Programming Languages  *
; *  Spring 2017                              *
; *  Student Version                          *
; *********************************************

;; contains "ctv", "A", and "reduce" definitions
(load "include.ss")
;; contains simple dictionary definition
(load "dictionary.ss")

;; -----------------------------------------------------
;; HELPER FUNCTIONS

;; *** CODE FOR ANY HELPER FUNCTION GOES HERE ***
(define addkey
  (lambda (val k)
    (+ val (* k 29)))
)

(define key2
  (lambda (w k)
    (if (eq?(length w) 1)
        (cons(ctv (car w)) '())
     (cons (ctv (car w)) (key2 (cdr w) k)) ;; *** FUNCTION BODY IS MISSING ***
     
     )
     )
  )


;(define x '())

(define single-vector
  (lambda (vector x)
    (if (eq? (length vector) 0)
         #f
         (if(= (car x) (car vector))
            #t
            (single-vector (cdr vector) x)
         )
     )
  )
)

(define map-bitvector 
   (lambda (bit-vector list)
     
     (if (eq? (length bit-vector) 0)
         #f
         (or (single-vector (car bit-vector) list) (map-bitvector (cdr bit-vector) list))
         )
     )
 )
(define apply-hash-functions-single-bitvector
  (lambda (hashfunction bit-vector)
  (if(eq? (length hashfunction) 1)
     (cons (single-bitvector (car hashfunction) bit-vector) '())
     (cons (single-bitvector (car hashfunction) bit-vector) (apply-hash-functions-single-bitvector (cdr hashfunction) bit-vector))
     )
  )
  )
(define single-bitvector
  (lambda (hashfunction bit-vector)
    (hashfunction (key bit-vector))
    )
  )

(define gen-bitvector
    (lambda (hashfunction bit-vector)
      (if (eq? (length bit-vector) 1)
          (cons ( hashfunction (key (car bit-vector))) '())
          (cons (hashfunction (key (car bit-vector))) (gen-bitvector hashfunction (cdr bit-vector)))
      )
      )
 )
(define apply-hash-functions
  (lambda (hashfunction bit-vector)
  (if(eq? (length hashfunction) 1)
     (cons (gen-bitvector (car hashfunction) bit-vector) '())
     (cons (gen-bitvector (car hashfunction) bit-vector) (apply-hash-functions (cdr hashfunction) bit-vector))
     )
  )
  )
;; -----------------------------------------------------
;; KEY FUNCTION

(define key
  (lambda (w)
    (reduce addkey (key2 w 5187) 5187)
     ))

;; -----------------------------------------------------
;; EXAMPLE KEY VALUES
;;   (key '(h e l l o))       = 106402241991
;;   (key '(m a y))           = 126526810
;;   (key '(t r e e f r o g)) = 2594908189083745

;; -----------------------------------------------------
;; HASH FUNCTION GENERATORS

;; value of parameter "size" should be a prime number
(define gen-hash-division-method
  (lambda (size) ;; range of values: 0..size-1
    (lambda (k)
    (modulo k size) ;; *** FUNCTION BODY IS MISSING ***
)))

;; value of parameter "size" is not critical
;; Note: hash functions may return integer values in "real"
;;       format, e.g., 17.0 for 17

(define gen-hash-multiplication-method
  (lambda (size) ;; range of values: 0..size-1
     (lambda (k)
       (floor(* size (- (* k A) (floor(* k A)))))))) 


;; -----------------------------------------------------
;; EXAMPLE HASH FUNCTIONS AND HASH FUNCTION LISTS

(define hash-1 (gen-hash-division-method 70111))
(define hash-2 (gen-hash-division-method 89997))
(define hash-3 (gen-hash-multiplication-method 700224))
(define hash-4 (gen-hash-multiplication-method 900))

(define hashfl-1 (list hash-1 hash-2 hash-3 hash-4))
(define hashfl-2 (list hash-1 hash-3))
(define hashfl-3 (list hash-2 hash-3))

;; -----------------------------------------------------
;; EXAMPLE HASH VALUES
;;   to test your hash function implementation
;;
;;  (hash-1 '(h e l l o))       ==> 35616
;;  (hash-1 '(m a y))           ==> 46566
;;  (hash-1 '(t r e e f r o g)) ==> 48238
;;
;;  (hash-2 '(h e l l o))       ==> 48849
;;  (hash-2 '(m a y))           ==> 81025
;;  (hash-2 '(t r e e f r o g)) ==> 16708
;;
;;  (hash-3 '(h e l l o))       ==> 6331.0
;;  (hash-3 '(m a y))           ==> 2456.0
;;  (hash-3 '(t r e e f r o g)) ==> 1806.0
;;
;;  (hash-4 '(h e l l o))       ==> 788.0
;;  (hash-4 '(m a y))           ==> 306.0
;;  (hash-4 '(t r e e f r o g)) ==> 225.0


;; -----------------------------------------------------
;; SPELL CHECKER GENERATOR

(define gen-checker
  (lambda (hashfunctionlist dict)
    (define list (apply-hash-functions hashfunctionlist dict))
    (define hashfunctions hashfunctionlist)
    (lambda (word)
      ;(define x (key word))
      (map-bitvector list (apply-hash-functions-single-bitvector hashfunctionlist word));; *** FUNCTION BODY IS MISSING ***
      )
      )
  )


;; -----------------------------------------------------
;; EXAMPLE SPELL CHECKERS

(define checker-1 (gen-checker hashfl-1 dictionary))
(define checker-2 (gen-checker hashfl-2 dictionary))
(define checker-3 (gen-checker hashfl-3 dictionary))

;; EXAMPLE APPLICATIONS OF A SPELL CHECKER
;;
;  (checker-1 '(a r g g g g)) ;==> #f
;  (checker-2 '(h e l l o)) ;==> #t
;  (checker-2 '(a r g g g g)) ;==> #t  // false positive
;  (checker-1 '(h e l l o))
;  (checker-1 '(t r e e f r o g))
;  (checker-3 '(t r e e f r o g)) ;==> #t  // false positive
;  (checker-3 '(h e l l o))
;  (checker-3 '(m a y))
