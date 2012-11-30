/* C++ code produced by gperf version 3.0.3 */
/* Command-line: gperf -L C++ -E -t /private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "jp.co.aircast.module.ModulesampleModule.h"
#include "jp.co.aircast.module.MakeIntentProxy.h"
#include "jp.co.aircast.module.ALModuleProxy.h"
#include "jp.co.aircast.module.VideoViewProxy.h"


#line 16 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 6, duplicates = 0 */

class ModulesampleBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
ModulesampleBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
ModulesampleBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 4,
      MIN_WORD_LENGTH = 34,
      MAX_WORD_LENGTH = 39,
      MIN_HASH_VALUE = 34,
      MAX_HASH_VALUE = 39
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""},
#line 20 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"
      {"jp.co.aircast.module.ALModuleProxy", ::jp::co::aircast::module::modulesample::ALModuleProxy::bindProxy, ::jp::co::aircast::module::modulesample::ALModuleProxy::dispose},
#line 21 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"
      {"jp.co.aircast.module.VideoViewProxy", ::jp::co::aircast::module::modulesample::VideoViewProxy::bindProxy, ::jp::co::aircast::module::modulesample::VideoViewProxy::dispose},
#line 19 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"
      {"jp.co.aircast.module.MakeIntentProxy", ::jp::co::aircast::module::modulesample::MakeIntentProxy::bindProxy, ::jp::co::aircast::module::modulesample::MakeIntentProxy::dispose},
      {""}, {""},
#line 18 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"
      {"jp.co.aircast.module.ModulesampleModule", ::jp::co::aircast::module::ModulesampleModule::bindProxy, ::jp::co::aircast::module::ModulesampleModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 22 "/private/var/folders/nW/nWVA5PeZHOWqI1R6YVwGN++++TM/-Tmp-/develop/modulesample-generated/KrollGeneratedBindings.gperf"

